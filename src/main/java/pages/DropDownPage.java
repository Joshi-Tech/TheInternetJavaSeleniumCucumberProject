package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends CommonAttributes {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropDown() {
        WebElement element = driver.findElement(By.cssSelector("#dropdown"));
        element.click();
        Select select = new Select(element);
        select.selectByVisibleText("Option 1");
    }
}
