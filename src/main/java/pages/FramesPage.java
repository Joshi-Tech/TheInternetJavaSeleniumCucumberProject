package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesPage extends CommonAttributes {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String iFrameText() {
        //driver.findElement(By.cssSelector("div[aria-label='Close']")).click();
        driver.findElement(By.cssSelector("a[href='/iframe']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tox-edit-area__iframe")));

        driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe")));
        return driver.findElement(By.cssSelector("#tinymce>p")).getText();
    }

    public String getTextFromAlertBox() {
        driver.switchTo().defaultContent();
        return driver.findElement(By.cssSelector("p>span>strong")).getText();
    }
}
