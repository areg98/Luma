package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Constants.SignInPageEnum.*;
import static utils.CustomWebElement.*;
import static utils.WaitHelper.waitUntilElementAppeared;

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
        PageFactory.initElements(driver, this);
    }

    public void validSignIn() {
        sendKey(userNameField, VALID_EMAIL.getValue());
        sendKey(passField, VALID_PASSWORD.getValue());
        click(submitButton);
    }

    public String inValidSignIn(){
        sendKey(userNameField, INVALID_EMAIL.getValue());
        sendKey(passField, INVALID_PASSWORD.getValue());
        click(submitButton);
        return getText(incorrectSignInError);

    }

    public String emptyEmailSignIn(){
        sendKey(userNameField, "");
        sendKey(passField, VALID_PASSWORD.getValue());
        click(submitButton);
        return getText(emailError);

    }

    public String emptyPassSignIn(){
        sendKey(userNameField, VALID_EMAIL.getValue());
        sendKey(passField, "");
        click(submitButton);
        return getText(passError);

    }

    public String getBaseText(){
        return getText(baseText);
    }

    public String getLoginText() {
        return getText(loginText);
    }

    public String getRegisteredUserTest() {
        return getText(registeredUserText);
    }

    public String getNewCustomerText() {
        return getText(newCustomerText);
    }

    public void clickOnCreateAnAccountButton() {
        click(createAnAccountButton);
    }

    @Override
    protected void load() {
        driver.navigate().to(SIGN_URL.getValue());
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try{
            waitUntilElementAppeared(submitButton);
        }catch (Exception e){
            throw new Error();
        }

    }



}
