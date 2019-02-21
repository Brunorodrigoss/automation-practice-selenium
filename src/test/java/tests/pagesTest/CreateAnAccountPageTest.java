package tests.pagesTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.pages.CreateAnAccountPage;
import tests.setups.Setups;

public class CreateAnAccountPageTest {
    private WebDriver driver;
    private CreateAnAccountPage browser;
    private Setups setups = new Setups();

    @Before
    public void setUp() {
        setups.setPropertyOS();
        driver = new ChromeDriver();
        this.browser = new CreateAnAccountPage(driver);
        setups.createAnAccountSetup(driver, browser);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreateAnAccount_instrumentedTest() {
        browser.checkElementsIsDisplayed();
    }

    @Test
    public void testCreateAnAccount_fillFields() {
        browser.fillGender();
        browser.fillFirstName();
        browser.fillLastName();
        browser.fillPassword();
        browser.fillDayOfBirth();
        browser.fillMonthOfBirth();
        browser.fillYearOfBirth();
        browser.fillAdressFirstName();
        browser.fillAdressLastName();
        browser.fillCompany();
        browser.fillAdressCompany();
        browser.fillAdressLine2();
        browser.fillAdressCity();
        browser.fillAdressState();
        browser.fillAdressPostalCode();
        browser.fillAdressCountry();
        browser.fillAdressAditionalInformation();
        browser.fillAdressHomePhone();
        browser.fillAdressMobilePhone();
        browser.fillAdressReference();
        browser.clickButtonRegister();
        browser.checkLoginName();
        browser.clickSignOut();
    }
}
