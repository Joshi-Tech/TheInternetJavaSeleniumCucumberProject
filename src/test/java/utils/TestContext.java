package utils;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import remoteTest.LambdaTest;

public class TestContext {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;
    private boolean status = false;

    private final ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver initializedWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void setUp() {
        if (configFileReader.runTestMode().equals("remote")) {
            try {
                remoteWebDriver = LambdaTest.setCapability();
                remoteWebDriver.get(configFileReader.getApplicationUrl()); // Navigate to the application under test
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            initializedWebDriver();
        }
    }


    public void tearDown() {
        if (configFileReader.runTestMode().equals("remote")) {
            if (remoteWebDriver != null) {
                ((JavascriptExecutor) remoteWebDriver).executeScript("lambda-status=" + status);
                remoteWebDriver.quit();
            }
        } else {
            driver.quit();
        }
    }
}
