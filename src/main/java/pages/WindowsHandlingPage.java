package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsHandlingPage extends CommonAttributes {
    private static String parentWindow;

    public WindowsHandlingPage(WebDriver driver) {
        super(driver);
    }

    public String clickOnMainWindow() {
        parentWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".example>a")).click();
        //Get the handles of all open windows
        Set<String> allWindows = driver.getWindowHandles();
        //Switch to the new window (not the parent window)
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;  // Once switched, break the loop
            }
        }
        return driver.findElement(By.cssSelector(".example>h3")).getText();
    }

    public String getTitleOfMainWindow() {
        driver.switchTo().window(parentWindow);
        return driver.findElement(By.cssSelector("div[style='text-align: center;']")).getText();
    }
}
