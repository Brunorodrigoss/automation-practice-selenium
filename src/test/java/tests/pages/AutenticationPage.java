package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class AutenticationPage {
    private WebDriver driver;
    private String xpathLabelEmailAdress = "//*[@id=\"login_form\"]/div/div[1]/label";
    private String xpathLabelPassword = "//*[@id=\"login_form\"]/div/div[2]/label";
    private String xpathLabelCreateAnAccount = "//*[@id=\"create-account_form\"]/h3";
    private String xpathLabelCreateAnAccountContent = "//*[@id=\"create-account_form\"]/div/p";
    private String xpathLabelCreateAnAccountEmail = "//*[@id=\"create-account_form\"]/div/div[2]/label";
    private String xpathButtonCreateAnAccount = "//*[@id=\"SubmitCreate\"]/span";
    private String xpathErrorMessage = "//*[@id=\"create_account_error\"]/ol/li";

    public AutenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void testClickButton_SingIn(){
        WebElement headerUserInfo = driver.findElement(By.className("header_user_info"));
        headerUserInfo.findElement(By.className("login")).click();
    }

    public void loginCheckElementsIsDisplayed() {
        WebElement formLogin = driver.findElement(By.id("login_form"));
        formLogin.isDisplayed();
        formLogin.findElement(By.className("page-subheading")).isDisplayed();
        formLogin.findElement(By.xpath(xpathLabelEmailAdress)).isDisplayed();
        formLogin.findElement(By.id("email")).isDisplayed();
        formLogin.findElement(By.xpath(xpathLabelPassword)).isDisplayed();
        formLogin.findElement(By.id("passwd")).isDisplayed();
        formLogin.findElement(By.linkText("Forgot your password?")).isDisplayed();
        formLogin.findElement(By.id("SubmitLogin")).isDisplayed();
    }

    public void loginCheckTextElements() {
        WebElement formLogin = driver.findElement(By.id("login_form"));
        assertEquals("ALREADY REGISTERED?",formLogin.findElement(By.className("page-subheading")).getText());
        assertEquals("Email address",formLogin.findElement(By.xpath(xpathLabelEmailAdress)).getText());
        assertEquals("Password",formLogin.findElement(By.xpath(xpathLabelPassword)).getText());
        assertEquals("Forgot your password?",formLogin.findElement(By.linkText("Forgot your password?")).getText());
        assertEquals("Sign in",formLogin.findElement(By.id("SubmitLogin")).getText());
    }

    public void clickButtonSignIn() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void checkLoginErrorMessages(String expectedText) {
        assertEquals(expectedText, driver.findElement(By.className("alert-danger")).getText());
    }

    public void fillSignInEmailField(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void fillSignInPasswordField(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void clickLinkForgotYourPassword() {
        driver.findElement(By.linkText("Forgot your password?")).click();
    }

    public void createAnAccountCheckElementsIsDisplayed() {
        WebElement formCreateAccount = driver.findElement(By.id("create-account_form"));
        formCreateAccount.isDisplayed();
        formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccount)).isDisplayed();
        formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccountContent)).isDisplayed();
        formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccountEmail)).isDisplayed();
        formCreateAccount.findElement(By.id("email_create")).isDisplayed();
        formCreateAccount.findElement(By.id("SubmitCreate")).isDisplayed();
    }

    public void createAnAccountCheckTextElements() {
        WebElement formCreateAccount = driver.findElement(By.id("create-account_form"));
        assertEquals("CREATE AN ACCOUNT",formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccount)).getText());
        assertEquals("Please enter your email address to create an account.",formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccountContent)).getText());
        assertEquals("Email address",formCreateAccount.findElement(By.xpath(xpathLabelCreateAnAccountEmail)).getText());
    }

    public void clickButtonCreateAnAccount() {
        WebElement formCreateAccount = driver.findElement(By.id("create-account_form"));
        formCreateAccount.findElement(By.xpath(xpathButtonCreateAnAccount)).click();
    }

    public void checkCreateAnAccountErrorMessages(String expectedText) {
        assertEquals(expectedText, driver.findElement(By.xpath(xpathErrorMessage)).getText());
    }

    public void fillCreateAnAccountEmailField(String email) {
        WebElement formCreateAccount = driver.findElement(By.id("create-account_form"));
        formCreateAccount.findElement(By.id("email_create")).sendKeys(email);
    }

    public void checkLoginName() {
        assertEquals("Bruno Soares", driver.findElement(By.className("account")).getText());
    }
}
