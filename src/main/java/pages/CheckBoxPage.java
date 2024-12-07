package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends CommonAttributes {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckBoxClicked() {
        WebElement element = driver.findElements(By.cssSelector("input[type='checkbox']"))
                .stream().toList().get(0);
        element.click();
        return true;
    }
}
