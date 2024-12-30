package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDropPage extends CommonAttributes {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(String image1, String image2) {
        Actions actions = new Actions(driver);
        Actions dragAndDrop = actions.dragAndDrop(driver.findElement(By.id("column-" + image1)), driver.findElement(By.id("column-" + image2)));
        dragAndDrop.perform();
    }

    public List<String> getImageText() {
        return driver.findElements(By.cssSelector(".column>header"))
                .stream().map(WebElement::getText)
                .toList();
    }
}
