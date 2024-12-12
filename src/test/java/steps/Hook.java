package steps;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import remoteTest.LambdaTest;

public class Hook {
    private static WebDriver driver;
    private RemoteWebDriver remoteWebDriver;
    private final ConfigFileReader configFileReader = new ConfigFileReader();
    private boolean status = false;

    @Before
    public void setUp() {
        if (configFileReader.runTestMode().equalsIgnoreCase("remote")) {
            initializeRemoteDriver();
        } else {
            initializeLocalDriver();
        }
    }

    private void initializeRemoteDriver() {
        try {
            remoteWebDriver = LambdaTest.setCapability();
            remoteWebDriver.get(configFileReader.getApplicationUrl());
            driver = remoteWebDriver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize remote driver: " + e.getMessage(), e);
        }
    }

    private void initializeLocalDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @After
    public void tearDown() {
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
