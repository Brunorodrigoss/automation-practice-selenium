package tests.setups;

import org.openqa.selenium.WebDriver;
import tests.builder.EmailBuilder;
import tests.pages.AutenticationPage;
import tests.pages.CartPage;
import tests.pages.CreateAnAccountPage;

import java.util.concurrent.TimeUnit;

public class Setups {

    public void setPropertyOS(){
        getPropertyForMacOS();
    }

    public void getPropertyForMacOS() {
        System.setProperty("webdriver.chrome.driver", "/Users/bruno/Desktop/SeleniumJava/drivers/chromedriver");
    }

    public void getPropertyForWindowsOS() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Desktop\\SeleniumJava\\drivers\\chromedriver");
    }

    private void defaultSetup(WebDriver driver) {
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void homePageSetup(WebDriver driver) {
        defaultSetup(driver);
    }

    public void createAnAccountSetup(WebDriver driver, CreateAnAccountPage browser) {
        defaultSetup(driver);
        browser.testClickButton_SingIn();
        browser.fillCreateAnAccountEmailField(EmailBuilder.build());
        browser.clickButtonCreateAnAccount();
    }

    public void autenticationPageSetup(WebDriver driver, AutenticationPage browser) {
        defaultSetup(driver);
        browser.testClickButton_SingIn();
    }

    public void cartPageSetup(WebDriver driver, CartPage browser) {
        defaultSetup(driver);
        browser.clickCartOption();
    }
}
