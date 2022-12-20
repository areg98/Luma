package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

import static Enums.RegistrationPageEnum.*;
import static Enums.RegistrationPageEnum.INVALID_EMAIL;
import static Enums.SignInPageEnum.*;
import static utils.CustomWebElement.*;

import org.openqa.selenium.support.Color;

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

    // Todo Add List for input fields and labels

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        getHeader().clickOnRegButton();
        PageFactory.initElements(driver, this);
    }

    public String openRegistrationPage() {
        return driver.getCurrentUrl();
    }

    public String createAnAccount() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
        return successMessage.getText();

    }

    public void invalidEmailReg() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, INVALID_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutFirstName() throws InterruptedException {
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutLastName() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutEmail() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutPass() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithOutConfirmPass() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void regWithDifferentPass() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, RANDOM_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue() + 1);
        click(createAnAccountButton);
    }

    public void regWithUsedEmail() throws InterruptedException {
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        sendKey(email, VALID_EMAIL.getValue());
        sendKey(pass, RANDOM_PASS.getValue());
        sendKey(confirmPass, RANDOM_PASS.getValue());
        click(createAnAccountButton);
    }

    public void checkWeakPassStrength() {
        sendKey(pass, INVALID_PASSWORD.getValue());
    }

    public void checkMediumPassStrength() {
        sendKey(pass, "123aaAQ!");
    }

    public void checkStrongPassStrength() {
        sendKey(pass, VALID_PASSWORD.getValue());
    }

    public void checkVeryStrongPassStrength() {
        sendKey(pass, VALID_PASSWORD.getValue() + "aa");
    }


    public String getPassStrengthColor() throws InterruptedException {
        Thread.sleep(2000);
        String script = "return window.getComputedStyle(document.querySelector('.password-strength-meter'),'::before').getPropertyValue('background-color')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String color = js.executeScript(script).toString();
        color = Color.fromString(color).asHex();
        return color;
    }


    public String getUsedEmailErrorText() {
        return usedEmailError.getText();
    }

    public Boolean checkUsedEmailError() {
        return usedEmailError.isDisplayed();
    }

    public String getConfirmPassError() {
        return confirmPassError.getText();
    }

    public Boolean checkConfirmPassError() {
        return confirmPassError.isDisplayed();
    }

    public String getPassError() {
        return passError.getText();
    }

    public Boolean checkPassError() {
        return passError.isDisplayed();
    }

    public String getLastNameErrorMessage() {
        return lastNameErrorMessage.getText();
    }

    public Boolean checkLastNameErrorMessage() {
        return lastNameErrorMessage.isDisplayed();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public Boolean checkEmailErrorMessage() {
        return emailErrorMessage.isDisplayed();
    }

    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }

    public Boolean checkFirstNameErrorMessage() {
        return firstNameErrorMessage.isDisplayed();
    }

    public Boolean checkPageTitle() {
        return pageTitle.isDisplayed();
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public Boolean checkPersInfoText() {
        return infoTexts.get(0).isDisplayed();
    }

    public String getPersInfoText() {
        return infoTexts.get(0).getText();
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

    public void fillAllFields() throws InterruptedException {
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
}
