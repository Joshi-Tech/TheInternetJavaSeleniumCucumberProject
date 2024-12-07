package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverOverPage extends CommonAttributes {

    public HoverOverPage(WebDriver driver) {
        super(driver);
    }

    public String user(int userNumber, String user) {
        List<WebElement> elements = driver.findElements(By.cssSelector("img[alt='User Avatar']"));
        WebElement element = elements.get(userNumber);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return driver.findElements(By.cssSelector(".figcaption>h5"))
                .stream().filter(x -> x.getText().contains(user))
                .toList().get(0).getText();
    }
}
