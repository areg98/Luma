package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import static Enums.SignInPageEnum.*;
import static utils.CustomWebDriver.*;
import static utils.CustomWebElement.*;

public class SignInPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement userNameField;
    @FindBy(id = "pass")
    private WebElement passField;
    @FindBy(id = "send2")
    private WebElement submitButton;
    @FindBy(className = "not-logged-in")
    private WebElement notLoggedInText;
    @FindBy(className = "base")
    private WebElement baseText;
    @FindBy(css = "[class='field note']")
    private WebElement loginText;
    @FindBy(id = "block-customer-login-heading")
    private WebElement registeredUserText;
    @FindBy(id = "block-new-customer-heading")
    private WebElement newCustomerText;
    @FindBy(css = "[class='action create primary']")
    private WebElement createAnAccountButton;
    @FindBy(id = "email-error")
    private WebElement emailError;
    @FindBy(id = "pass-error")
    private WebElement passError;
    @FindBy(css= "[class='message-error error message']")
    private WebElement incorrectSignInError;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        BasePage basePage = new BasePage();
        basePage.getHeader().clickOnSignInButton();
        PageFactory.initElements(driver, this);

    }

    public String validSignIn() throws InterruptedException {

        sendKey(userNameField, VALID_EMAIL.getValue());
        sendKey(passField, VALID_PASSWORD.getValue());
        click(submitButton);
        Thread.sleep(2000);
        HomePageWithSignIn homePageWithSignIn = new HomePageWithSignIn(getDriver());
        return homePageWithSignIn.getLoggedInText();
    }

    public String inValidSignIn() throws InterruptedException {
        Thread.sleep(1000);
        sendKey(userNameField, INVALID_EMAIL.getValue());
        sendKey(passField, INVALID_PASSWORD.getValue());
        click(submitButton);
        Thread.sleep(1000);
        return incorrectSignInError.getText();

    }

    public String emptyEmailSignIn() throws InterruptedException {
        Thread.sleep(1000);
        sendKey(userNameField, "");
        sendKey(passField, VALID_PASSWORD.getValue());
        click(submitButton);
        Thread.sleep(1000);
        return emailError.getText();

    }

    public String emptyPassSignIn() throws InterruptedException {
        Thread.sleep(1000);
        sendKey(userNameField, VALID_EMAIL.getValue());
        sendKey(passField, "");
        click(submitButton);
        Thread.sleep(1000);
        return passError.getText();

    }

    public String getBaseText() throws InterruptedException {
        Thread.sleep(2000);
        return baseText.getText();
    }

    public String getLoginText() {
        return loginText.getText();
    }

    public String getRegisteredUserTest() {
        return registeredUserText.getText();
    }

    public String getNewCustomerText() {
        return newCustomerText.getText();
    }

    public void clickOnCreateAnAccountButton() {
        click(createAnAccountButton);
    }


}
