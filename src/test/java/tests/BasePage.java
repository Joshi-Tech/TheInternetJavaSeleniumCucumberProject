package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BasePage {

    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public CommonAttributes commonAttributes() {
        return new CommonAttributes(driver);
    }

    public HomePage homePage() {
        return new HomePage(driver);
    }

    public CheckBoxPage checkBoxPage() {
        return new CheckBoxPage(driver);
    }

    public DropDownPage dropDownPage() {
        return new DropDownPage(driver);
    }

    public ContextMenu contextMenuPage() {
        return new ContextMenu(driver);
    }

    public FramesPage framesPage() {
        return new FramesPage(driver);
    }

    public WindowsHandlingPage windowsHandlingPage() {
        return new WindowsHandlingPage(driver);
    }

    public HoverOverPage hoverOverPage() {
        return new HoverOverPage(driver);
    }
}
