package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu extends CommonAttributes {

    public ContextMenu(WebDriver driver) {
        super(driver);
    }

    private Actions contextMenuAction() {
        Actions actions = new Actions(driver);
        return actions.contextClick(driver.findElement(By.id("hot-spot")));
    }

    public String getAlertBoxText() {
        contextMenuAction().perform();
        return driver.switchTo().alert().getText();
    }

    public void clickContextMenu() {
        driver.switchTo().alert().accept();
    }
}
