package tests;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;
import remoteTest.LambdaTest;

public class BasePage {
    protected static WebDriver driver;

    public static RemoteWebDriver remoteWebDriver = null;
    boolean status = false;
    private final ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeEach
    public void setUp() {
        if (configFileReader.runTestMode().equals("remote")) {
            try {
                remoteWebDriver = LambdaTest.setCapability();
                remoteWebDriver.get(configFileReader.getApplicationUrl()); // Navigate to the application under test
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
        }
    }

    @AfterEach
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

    public CommonAttributes commonAttributes() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new CommonAttributes(remoteWebDriver);
        } else {
            return new CommonAttributes(driver);
        }
    }

    public HomePage homePage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new HomePage(remoteWebDriver);
        } else {
            return new HomePage(driver);
        }
    }

    public CheckBoxPage checkBoxPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new CheckBoxPage(remoteWebDriver);
        } else {
            return new CheckBoxPage(driver);
        }
    }

    public DropDownPage dropDownPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new DropDownPage(remoteWebDriver);
        } else {
            return new DropDownPage(driver);
        }
    }

    public ContextMenu contextMenuPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new ContextMenu(remoteWebDriver);
        } else {
            return new ContextMenu(driver);
        }
    }

    public FramesPage framesPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new FramesPage(remoteWebDriver);
        } else {
            return new FramesPage(driver);

        }
    }

    public WindowsHandlingPage windowsHandlingPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new WindowsHandlingPage(remoteWebDriver);
        } else {
            return new WindowsHandlingPage(driver);
        }
    }

    public HoverOverPage hoverOverPage() {
        if (configFileReader.runTestMode().equals("remote")) {
            return new HoverOverPage(remoteWebDriver);
        } else {
            return new HoverOverPage(driver);
        }
    }
}
