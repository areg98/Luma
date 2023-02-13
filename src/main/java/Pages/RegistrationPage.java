package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.RegistrationPageEnum.INVALID_EMAIL;
import static Constants.RegistrationPageEnum.*;
import static Constants.SignInPageEnum.*;
import static utils.CustomWebElement.*;
import static utils.WaitHelper.waitUntilColorToBeAppeared;
import static utils.WaitHelper.waitUntilElementAppeared;

public class RegistrationPage extends BasePage {
    private WebDriver driver;
    @FindBy(linkText = "Create an Account")
    private WebElement regButton;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "email_address")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement pass;
    @FindBy(id = "password-confirmation")
    private WebElement confirmPass;
    @FindBy(css = "[class='action submit primary']")
    private WebElement createAnAccountButton;
    @FindBy(css = "[class='message-success success message']")
    private WebElement successMessage;
    @FindBy(className = "legend")
    private List<WebElement> infoTexts;
    @FindBy(className = "page-title")
    private WebElement pageTitle;
    @FindBy(css = "[class='field field-name-firstname required']")
    private WebElement firstNameText;
    @FindBy(css = "[class='field field-name-lastname required']")
    private WebElement lastNameText;
    @FindBy(css = "[class='field required']")
    private WebElement emailText;
    @FindBy(css = "[class='field password required']")
    private WebElement passText;
    @FindBy(css = "[class='field confirmation required']")
    private WebElement confirmPassText;
    @FindBy(id = "email_address-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "firstname-error")
    private WebElement firstNameErrorMessage;
    @FindBy(id = "lastname-error")
    private WebElement lastNameErrorMessage;
    @FindBy(id = "password-error")
    private WebElement passError;
    @FindBy(id = "password-confirmation-error")
    private WebElement confirmPassError;
    @FindBy(css = "[class='message-error error message']")
    private WebElement usedEmailError;
    @FindBy(css = ".password-strength-meter")
    private WebElement passStrengthColor;
    @FindBy(id = "is_subscribed")
    private WebElement radioButtonNewsletter;

    // Todo Add List for input fields and labels

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openRegistrationPage() {
        return driver.getCurrentUrl();
    }

    public String createAnAccount()  {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
        return getText(successMessage);

    }

    public void invalidEmailReg()  {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, INVALID_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutFirstName()  {
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutLastName()  {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutEmail()  {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutPass(){
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutConfirmPass(){
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithDifferentPass(){
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue() + 1);
        click(createAnAccountButton);
    }

    public void regWithUsedEmail(){
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, VALID_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void checkWeakPassStrength() {
        sendKey(pass, WEEK_PASS.getValue());
        click(radioButtonNewsletter);
    }

    public void checkMediumPassStrength() {
        sendKey(pass, MEDIUM_PASS.getValue());
        click(radioButtonNewsletter);
    }

    public void checkStrongPassStrength() {
        sendKey(pass, STRONG_PASS.getValue());
        click(radioButtonNewsletter);
    }

    public void checkVeryStrongPassStrength() {
        sendKey(pass, VERY_STRONG_PASS.getValue());
        click(radioButtonNewsletter);
    }


    public String getPassStrengthColor() {
        waitUntilColorToBeAppeared(pass);
        String script = "return window.getComputedStyle(document.querySelector('.password-strength-meter'),'::before').getPropertyValue('background-color')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String color = js.executeScript(script).toString();
        color = Color.fromString(color).asHex();
        return color;
    }


    public String getUsedEmailErrorText() {
        return getText(usedEmailError);
    }

    public String getConfirmPassError() {
        return getText(confirmPassError);
    }

    public Boolean checkConfirmPassError() {
        return confirmPassError.isDisplayed();
    }

    public String getPassError() {
        return getText(passError);
    }

    public Boolean checkPassError() {
        return passError.isDisplayed();
    }

    public String getLastNameErrorMessage() {
        return getText(lastNameErrorMessage);
    }

    public Boolean checkLastNameErrorMessage() {
        return lastNameErrorMessage.isDisplayed();
    }

    public String getEmailErrorMessage() {
        return getText(emailErrorMessage);
    }

    public Boolean checkEmailErrorMessage() {
        return emailErrorMessage.isDisplayed();
    }

    public String getFirstNameErrorMessage() {
        return getText(firstNameErrorMessage);
    }

    public Boolean checkFirstNameErrorMessage() {
        return firstNameErrorMessage.isDisplayed();
    }

    public Boolean checkPageTitle() {
        return pageTitle.isDisplayed();
    }

    public String getPageTitleText() {
        return getText(pageTitle);
    }

    public Boolean checkPersInfoText() {
        return infoTexts.get(0).isDisplayed();
    }

    public String getPersInfoText() {
        return getText(infoTexts.get(0));
    }

    public Boolean checkSignInInfoText() {
        return infoTexts.get(1).isDisplayed();
    }

    public String getSignInInfoText() {
        return infoTexts.get(1).getText();
    }

    public Boolean checkFirstNameText() {
        return firstNameText.isDisplayed();
    }

    public Boolean checkLastNameText() {
        return lastNameText.isDisplayed();
    }

    public Boolean checkEmailText() {
        return emailText.isDisplayed();
    }

    public Boolean checkPassText() {
        return passText.isDisplayed();
    }

    public Boolean checkConfirmPassText() {
        return confirmPassText.isDisplayed();
    }

    public Boolean checkCreateButton() {
        return createAnAccountButton.isDisplayed();
    }

    public void fillAllFields(){
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
    }
    public String getLastNameText() {
        return lastName.getAttribute("value");
    }

    public String getFirstNameText() {
        return firstName.getAttribute("value");
    }

    public String getEmailText() {
        return email.getAttribute("value");
    }

    public String getPassText() {
        return pass.getAttribute("value");
    }

    public String getConfirmPssText() {
        return confirmPass.getAttribute("value");
    }

    public String getPassFieldType() {
        return pass.getAttribute("type");
    }

    public String getConfirmPassFieldType() {
        return confirmPass.getAttribute("type");
    }


    @Override
    protected void load() {
        driver.navigate().to(REGISTRATION_PAGE_URl.getValue());
    }


    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try{
            waitUntilElementAppeared(firstName);
        }catch (Exception e){
            throw new Error();
        }

    }
}
