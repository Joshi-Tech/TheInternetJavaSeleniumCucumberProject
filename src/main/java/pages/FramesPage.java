package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends CommonAttributes {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String iFrameText() {
        driver.findElement(By.cssSelector("a[href='/iframe']")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));
        return driver.findElement(By.cssSelector("#tinymce>p")).getText();
    }

    public String getTextFromAlertBox() {
        driver.switchTo().defaultContent();
        return driver.findElement(By.cssSelector("p>span>strong")).getText();
    }
}
