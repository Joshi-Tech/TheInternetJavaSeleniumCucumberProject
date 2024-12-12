package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import steps.hook.Hook;

import static org.junit.Assert.assertEquals;

public class StepDefinition {
    private static WebDriver driver;
    private BasePage basePage;

    @Given("they are on Home page")
    public void they_are_on_home_page() {
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
            default -> throw new RuntimeException("Value not found");
        }
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
        }
    }
}
