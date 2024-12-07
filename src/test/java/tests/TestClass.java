package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestClass extends BasePage {
    BasePage basePage = new BasePage();

    @Test
    void homePageTest() {
        assertEquals("Welcome to the-internet", basePage.homePage().getHeader());
        assertEquals("Available Examples", basePage.homePage().getH2());
    }

    @Test
    void checkBoxPageTests() {
        basePage.commonAttributes().clickOnLink("Checkboxes");
        assertEquals("Checkboxes", basePage.checkBoxPage().getH3());
        assertTrue(basePage.checkBoxPage().isCheckBoxClicked());
    }

    @Test
    void dropDownPageTests() {
        basePage.commonAttributes().clickOnLink("Dropdown");
        basePage.dropDownPage().clickDropDown();
        assertEquals("Dropdown List", basePage.dropDownPage().getH3());
    }

    @Test
    void contextMenuTests() {
        basePage.contextMenuPage().clickOnLink("Context Menu");
        assertEquals("You selected a context menu", basePage.contextMenuPage().getAlertBoxText());
        basePage.contextMenuPage().clickContextMenu();
        assertEquals("Context Menu", basePage.contextMenuPage().getH3());
    }

    @Test
    void framesPageTests() {
        basePage.contextMenuPage().clickOnLink("Frames");
        basePage.contextMenuPage().clickOnLink("iFrame");
        assertEquals("Your content goes here.", basePage.framesPage().iFrameText());
        assertEquals("Please request that the admin", basePage.framesPage().getTextFromAlertBox());
    }

    @Test
    void windowsHandleTests() {
        basePage.contextMenuPage().clickOnLink("Multiple Windows");
        assertEquals("New Window", basePage.windowsHandlingPage().clickOnMainWindow());
        assertEquals("Powered by Elemental Selenium", basePage.windowsHandlingPage().getTitleOfMainWindow());
    }

    @Test
    void hoverPage() {
        basePage.contextMenuPage().clickOnLink("Hovers");
        assertEquals("name: user1", basePage.hoverOverPage().user(0, "user1"));
        assertEquals("name: user2", basePage.hoverOverPage().user(1, "user2"));
        assertEquals("name: user3", basePage.hoverOverPage().user(2, "user3"));
    }
}
