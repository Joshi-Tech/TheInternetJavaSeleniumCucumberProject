package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import steps.hook.Hook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinition {
    private BasePage basePage;

    @Given("they are on Home page")
    public void they_are_on_home_page() {
        WebDriver driver;
        driver = new Hook().getDriver();
        basePage = new BasePage(driver);
        assertEquals("Welcome to the-internet", basePage.commonAttributes().getHeading());
    }

    @When("they click on {string}")
    public void they_click_on(String link) {
        switch (link.trim()) {
            case "Dropdown" -> basePage.commonAttributes().clickOnLink(link);
            case "Checkboxes" -> basePage.checkBoxPage().clickOnLink(link);
            case "Context Menu" -> basePage.contextMenu().clickOnLink(link);
            case "Frames" -> basePage.framesPage().clickOnLink(link);
            case "Hovers" -> basePage.hoverOverPage().clickOnLink(link);
            case "Multiple Windows" -> basePage.windowsHandlingPage().clickOnLink(link);
            case "Drag and Drop" -> basePage.dragAndDropPage().clickOnLink(link);
            default -> throw new RuntimeException("Value not found");
        }
    }

    @When("they can see Alert")
    public void they_can_see_alert() {
        assertEquals("You selected a context menu", basePage.contextMenu().getAlertBoxText());
    }

    @When("they drag and drop image {string} to image {string}")
    public void they_drag_and_drop_image_to_image(String image1, String image2) {
        basePage.dragAndDropPage().dragAndDrop(image1, image2);
    }

    @Then("they can see images correctly moved")
    public void they_can_see_images_correctly_moved() {
        Assert.assertEquals("A", basePage.dragAndDropPage().getImageText().get(1));
        Assert.assertEquals("B", basePage.dragAndDropPage().getImageText().get(0));
    }

    @Then("they can click on the Alert")
    public void they_can_click_on_the_alert() {
        basePage.contextMenu().clickContextMenu();
    }

    @Then("they can see {string} as expected")
    public void they_can_see_as_expected(String header) {
        switch (header.trim()) {
            case "Dropdown List" -> assertEquals("Dropdown List", basePage.homePage().getH3());
            case "Checkboxes" -> assertEquals("Checkboxes", basePage.dropDownPage().getH3());
            case "Context Menu" -> assertEquals("Context Menu", basePage.contextMenu().getH3());
            case "Frames" -> assertEquals("Frames", basePage.framesPage().getH3());
            case "Hovers" -> assertEquals("Hovers", basePage.hoverOverPage().getH3());
            case "Opening a new window" -> assertEquals("Opening a new window", basePage.windowsHandlingPage().getH3());
            case "Drag and Drop" -> assertEquals("Drag and Drop", basePage.windowsHandlingPage().getH3());
        }
    }

    @Then("first checkbox is clicked")
    public void first_checkbox_is_clicked() {
        assertTrue(basePage.checkBoxPage().isCheckBoxClicked());
    }

    @Then("they can select correct option")
    public void they_can_select_correct_option() {
        basePage.dropDownPage().clickDropDown();
    }

    @Then("they can see correct text in the Frame")
    public void they_can_see_correct_text_in_the_frame() {
        assertEquals("Your content goes here.", basePage.framesPage().iFrameText());
    }

    @Then("the can move back to main frame")
    public void the_can_move_back_to_main_frame() {
        assertEquals("Please request that the admin", basePage.framesPage().getTextFromAlertBox());

    }

    @Then("they can see {string} as {string}")
    public void they_can_see_as(String number, String user) {
        assertEquals("name: user1", basePage.hoverOverPage().user(Integer.parseInt(number), user));
    }

    @Then("they click on the Main window to move to child window")
    public void they_click_on_the_main_window_to_move_to_child_window() {
        assertEquals("New Window", basePage.windowsHandlingPage().clickOnMainWindow());
    }

    @Then("they can return return back to main window")
    public void they_can_return_return_back_to_main_window() {
        assertEquals("Powered by Elemental Selenium", basePage.windowsHandlingPage().getTitleOfMainWindow());
    }
}
