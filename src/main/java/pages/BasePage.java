package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
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

    public ContextMenu contextMenu() {
        return new ContextMenu(driver);
    }

    public DropDownPage dropDownPage() {
        return new DropDownPage(driver);
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
