package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartOption() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
    }

    public void checkAlertMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-warning")));
        assertEquals(expectedMessage, driver.findElement(By.className("alert-warning")).getText());
    }

    public void addItemToCart(String itemText, int indexItem) {
        HomePage homePage = new HomePage(driver);
        homePage.fillTheSearchField(itemText);
        homePage.clickSearchButton();
        homePage.clickItem(itemText, indexItem);
        homePage.clickAddToCartButton();
        homePage.clickProceedToCheckout();
    }

    public void removeItemToCart(int quantity) {
        if (quantity > 0) {
            for(int i = quantity; i > 0; i --) {
                driver.findElement(By.id("cart_quantity_down_5_19_0_0")).click();
            }
        }
    }

    public void clickToAddQuantity(int quantity) {
        if (quantity > 0) {
            for(int i = quantity; i > 0; i --) {
                driver.findElement(By.id("cart_quantity_up_5_19_0_0")).click();
            }
        }
    }

    public void checkQuantityItemsInCart(String quantity) throws InterruptedException {
        Thread.sleep(5000);
        WebElement cartQuantity = driver.findElement(By.className("shopping_cart"));
        assertEquals(quantity, cartQuantity.findElement(By.className("ajax_cart_quantity")).getText());
    }

    public void checkUnitPrice(int index) {
        switch (index){
            case 10:
                assertEquals("$28.98", driver.findElement(By.xpath("//*[@id=\"total_product_price_5_19_0\"]")).getText());
                break;

            case 11:
                assertEquals("$50.99", driver.findElement(By.xpath("//*[@id=\"total_product_price_4_16_0\"]")).getText());
                break;
        }
    }

    public void checkTotalPrice(String totalPrice) {
        assertEquals(totalPrice, driver.findElement(By.xpath("//*[@id=\"total_price_without_tax\"]")).getText());
    }

    public void removeItemToCartByTrashIcon() {
        driver.findElement(By.className("icon-trash")).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.linkText("Proceed to checkout")).click();
    }
}
