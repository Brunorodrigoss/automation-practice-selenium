package tests.pagesTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.builder.EmailBuilder;
import tests.pages.AutenticationPage;
import tests.setups.Setups;

public class AutenticationPageTest {
    private WebDriver driver;
    private AutenticationPage browser;
    private Setups setups = new Setups();

    @Before
    public void setUp() {
        setups.setPropertyOS();
        driver = new ChromeDriver();
        this.browser = new AutenticationPage(driver);
        setups.autenticationPageSetup(driver, browser);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNonRegisteredUserLogin_instrumentedTest() {
        browser.loginCheckElementsIsDisplayed();
        browser.loginCheckTextElements();
    }

    @Test
    public void testNonRegisteredUserLogin_noEmailAndPassword_clickButtonSignIn() {
        browser.clickButtonSignIn();
        browser.checkLoginErrorMessages("There is 1 error\n" + "An email address required.");
    }

    @Test
    public void testNonRegisteredUserLogin_emailNoPassword_clickButtonSignIn() {
        browser.fillSignInEmailField("bruno@gmail.com");
        browser.clickButtonSignIn();
        browser.checkLoginErrorMessages("There is 1 error\n" + "Password is required.");
    }

    @Test
    public void testNonRegisteredUserLogin_invalidEmailAndPassword_clickButtonSignIn() {
        browser.fillSignInEmailField("bruno@gmail.com");
        browser.fillSignInPasswordField("123456");
        browser.clickButtonSignIn();
        browser.checkLoginErrorMessages("There is 1 error\n" + "Authentication failed.");
    }

    @Test
    public void testNonRegisteredUserLogin_clickLinkForgotYourPassword() {
        browser.clickLinkForgotYourPassword();
    }

    @Test
    public void testNonRegisteredUserCreateAnAccount_instrumentedTest() {
        browser.createAnAccountCheckElementsIsDisplayed();
        browser.createAnAccountCheckTextElements();
    }

    @Test
    public void testNonRegisteredUserCreateAnAccount_noEmail_clickButtonCreateAnAccount() {
        browser.clickButtonCreateAnAccount();
        browser.checkCreateAnAccountErrorMessages("Invalid email address.");
    }

    @Test
    public void testNonRegisteredUserCreateAnAccount_invalidEmail_clickButtonCreateAnAccount() {
        browser.fillCreateAnAccountEmailField("bruno");
        browser.clickButtonCreateAnAccount();
        browser.checkCreateAnAccountErrorMessages("Invalid email address.");
    }

    @Test
    public void testNonRegisteredUserCreateAnAccount_validEmail_clickButtonCreateAnAccount() {
        browser.fillCreateAnAccountEmailField(EmailBuilder.build());
        browser.clickButtonCreateAnAccount();
    }

    @Test
    public void testAutenticationPage_signIn_sucessfuly() {}
}
