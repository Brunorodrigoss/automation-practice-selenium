package tests.pagesTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.pages.CartPage;
import tests.setups.Setups;

public class CartPageTest {
    private WebDriver driver;
    private CartPage browser;
    private Setups setups = new Setups();

    @Before
    public void setUp() {
        setups.setPropertyOS();
        driver = new ChromeDriver();
        this.browser = new CartPage(driver);
        setups.cartPageSetup(driver, browser);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNonRegisteredUser_clickCartOption_checkMessage(){
        browser.checkAlertMessage("Your shopping cart is empty.");
    }

    @Test
    public void testNonRegisteredUser_cardOption_removeCartItem(){
        browser.addItemToCart("dress", 10);
        browser.removeItemToCart(1);
        browser.checkAlertMessage("Your shopping cart is empty.");
    }

    @Test
    public void testNonRegisteredUser_cardOption_addItemsToCart() throws InterruptedException {
        browser.addItemToCart("dress", 10);
        browser.clickToAddQuantity(5);
        browser.checkQuantityItemsInCart("6");
    }

    @Test
    public void testNonRegisteredUser_cardOption_addDifferentItemsToCart() throws InterruptedException {
        browser.addItemToCart("dress", 10);
        browser.addItemToCart("dress", 11);
        browser.clickCartOption();
    }

    @Test
    public void testNonRegisteredUser_cardOption_removeCartItems() {
        browser.addItemToCart("dress", 10);
        browser.clickToAddQuantity(7);
        browser.removeItemToCart(8);
        browser.checkAlertMessage("Your shopping cart is empty.");
    }

    @Test
    public void testNonRegisteredUser_cardOption_calcOrderCartItems() throws InterruptedException {
        testNonRegisteredUser_cardOption_addDifferentItemsToCart();
        browser.checkUnitPrice(10);
        browser.checkUnitPrice(11);
        browser.checkTotalPrice("$81.97");
    }

    @Test
    public void testNonRegisteredUser_cardOption_removeCartItensByTrashIcon() {
        browser.addItemToCart("dress", 10);
        browser.removeItemToCartByTrashIcon();
        browser.checkAlertMessage("Your shopping cart is empty.");
    }

    @Test
    public void testNonRegisteredUser_cardOption_addItensAndProceedToCheckout() throws InterruptedException {
        testNonRegisteredUser_cardOption_addDifferentItemsToCart();
        browser.clickProceedToCheckout();
    }
}
