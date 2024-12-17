package steps.hook;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import remotetest.LambdaTest;

public class Hook {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;
    private final ConfigFileReader configFileReader = new ConfigFileReader();

    @Before
    public void setUp() {
        if (configFileReader.testEnvironment().equalsIgnoreCase("remote")) {
            initializeRemoteDriver();
        } else {
            initializeLocalDriver();
        }
    }

    private void initializeRemoteDriver() {
        try {
            remoteWebDriver = LambdaTest.setCapability();
            if (remoteWebDriver != null) {
                remoteWebDriver.get(configFileReader.getApplicationUrl());
                driver = remoteWebDriver;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize remote driver: " + e.getMessage(), e);
        }
    }

    private void initializeLocalDriver() {
        String browserType = configFileReader.browserType();
        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://the-internet.herokuapp.com/");
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get("https://the-internet.herokuapp.com/");
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get("https://the-internet.herokuapp.com/");
            }
            default -> new RuntimeException("Unable to find driver");
        }
    }

    @After
    public void tearDown() {
        boolean status = false;
        if (driver != null) {
            try {
                if (remoteWebDriver != null) {
                    ((JavascriptExecutor) remoteWebDriver).executeScript("lambda-status=" + status);
                }
            } finally {
                driver.quit();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
