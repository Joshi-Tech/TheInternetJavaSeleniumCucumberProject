package utils;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import remotetest.LambdaTest;

public class TestContext {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;

    private final ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver initializedWebDriver() {
        WebDriverManager.chromedriver().setup();
        String driverType = "edge";
        switch (driverType) {
            case "chrome" -> {
                driver = new ChromeDriver();
                return driver;
            }
            case "edge" -> {
                driver = new EdgeDriver();
                return driver;
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                return driver;
            }
            default -> new RuntimeException("Unable to find driver");
        }
        return null;
    }

    public void setUp() {
        if (configFileReader.testEnvironment().equals("remote")) {
            try {
                remoteWebDriver = LambdaTest.setCapability();
                if (remoteWebDriver != null) {
                    remoteWebDriver.get(configFileReader.getApplicationUrl()); // Navigate to the application under test
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            initializedWebDriver();
        }
    }


    public void tearDown() {
        boolean status = false;
        if (configFileReader.testEnvironment().equals("remote")) {
            if (remoteWebDriver != null) {
                ((JavascriptExecutor) remoteWebDriver).executeScript("lambda-status=" + status);
                remoteWebDriver.quit();
            }
        } else {
            driver.quit();
        }
    }
}
