package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchButton() {
        WebElement searchBox = driver.findElement(By.id("searchbox"));
        searchBox.findElement(By.name("submit_search")).click();
    }

    public void checkAlertWarningMessages(String alertWarningText, String counterSearchText) {
        WebElement centerColumn = driver.findElement(By.id("center_column"));
        assertEquals(alertWarningText, centerColumn.findElement(By.className("alert-warning")).getText());
        assertEquals(counterSearchText, centerColumn.findElement(By.className("heading-counter")).getText());
    }

    public void fillTheSearchField(String text) {
        WebElement searchBox = driver.findElement(By.id("searchbox"));
        searchBox.findElement(By.id("search_query_top")).sendKeys(text);
        searchBox.findElement(By.name("submit_search")).click();
    }

    public void checkSearchMessages(String message) {
        WebElement centerColumn = driver.findElement(By.id("center_column"));
        assertEquals(message, centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
    }

    public void checkIsDisplayedElements(String search) {
        if (search.equals("dress")) {
            WebElement centerColumn = driver.findElement(By.id("center_column"));
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[6]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[7]")).isDisplayed();
        }
    }

    public void clickItem(String search, int index) {
        if (search.equals("dress")) {
            switch (index){
                case 10:
                    WebElement centerColumn10 = driver.findElement(By.id("center_column"));
                    centerColumn10.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).click();
                    break;

                case 11:
                    WebElement centerColumn11 = driver.findElement(By.id("center_column"));
                    centerColumn11.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")).click();
                    break;
            }
        }
    }

    public void clickAddToCartButton() {
        driver.findElement(By.linkText("Add to cart")).click();
    }

    public void clickProceedToCheckout() {
        WebElement buttonContainer = driver.findElement(By.className("button-container"));
        buttonContainer.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
    }
}
