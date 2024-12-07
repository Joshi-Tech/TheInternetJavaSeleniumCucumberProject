package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonAttributes {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(By.cssSelector(".heading")).getText();
    }

    public String getH2() {
        return driver.findElement(By.cssSelector("#content>h2")).getText();
    }
}
