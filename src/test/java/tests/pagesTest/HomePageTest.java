package tests.pagesTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.pages.HomePage;
import tests.setups.Setups;

public class HomePageTest {
    private WebDriver driver;
    private HomePage browser;
    private Setups setups = new Setups();

    @Before
    public void setUp() {
        setups.setPropertyOS();
        driver = new ChromeDriver();
        this.browser = new HomePage(driver);
        setups.homePageSetup(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNonRegisteredUser_emptySearchForAnItem_checkMessages() {
        browser.clickSearchButton();
        browser.checkAlertWarningMessages("Please enter a search keyword", "0 results have been found.");
    }

    @Test
    public void testNonRegisteredUser_searchForExistingItems() {
        browser.fillTheSearchField("dress");
        browser.clickSearchButton();
        browser.checkSearchMessages("SEARCH  \"DRESS\"\n" + "7 results have been found.");
    }

    @Test
    public void testNonRegisteredUser_searchForNonExistingItems_checkMessages() {
        browser.fillTheSearchField("beer");
        browser.checkAlertWarningMessages("No results were found for your search \"beer\"", "0 results have been found.");
    }

    @Test
    public void testNonRegisteredUser_searchForReturnItems_checkIsDiplayedItems() {
        testNonRegisteredUser_searchForExistingItems();
        browser.checkIsDisplayedElements("dress");
    }

    @Test
    public void testNonRegisteredUser_addItemToCart() {
        testNonRegisteredUser_searchForExistingItems();
        browser.clickItem("dress", 10);
        browser.clickAddToCartButton();
        browser.clickProceedToCheckout();
    }

    @Test
    public void testNonRegisteredUser_fillMaximumSearchField() {
        String textSearch = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"+
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book. ";
        browser.fillTheSearchField(textSearch);
        browser.checkAlertWarningMessages("No results were found for your search \"" + textSearch + "\"", "0 results have been found.");
    }

    @Test
    public void testNonRegisteredUser_cardOption_addItemToCart(){
        browser.fillTheSearchField("dress");
        browser.clickSearchButton();
        browser.clickItem("dress", 10);
        browser.clickAddToCartButton();
        browser.clickProceedToCheckout();
    }
}
