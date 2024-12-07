package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonAttributes {

    protected WebDriver driver;

    public CommonAttributes(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLink(String link) {
        driver.findElement(By.xpath("//*[text()='" + link + "']")).click();
    }

    public String getH3() {
        return driver.findElement(By.cssSelector(".example>h3")).getText();
    }
}
