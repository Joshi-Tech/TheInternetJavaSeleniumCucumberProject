package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonAttributes extends BasePage {

    protected WebDriver driver;

    public CommonAttributes(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnLink(String link) {
        driver.findElement(By.xpath("//*[text()='" + link + "']")).click();
    }

    public String getH3() {
        return driver.findElement(By.cssSelector(".example>h3")).getText();
    }

    public String getHeading() {
        return driver.findElement(By.cssSelector(".heading")).getText();
    }
}
