import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static Enums.RegistrationPageEnum.*;
import static utils.CustomWebDriver.getDriver;
import static utils.CustomWebElement.*;

//        Check if the user able to signup or register by entering the valid data in all the fields.
//        Check the registration form by entering the data only in some mandatory fields.
//        Check the alert message for all the mandatory fields.
//        Check the confirmation message when the user is successfully signup or register.
//        Check if all the fields have a valid label and placeholder.
//        Check after clicking on the cancel button whether all the fields have cleared the value or not.
//        Check whether the password field values are displayed in an encrypted format or not.
//        Check whether the validation is added for passwords and confirm whether passwords are the same or not.
//        Check by entering an already registered email address, Check if the error message is displaying or not.

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;
    WebDriver driver = getDriver();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethods() {
        registrationPage = new RegistrationPage(getDriver());
    }

    @BeforeGroups({"password", "labels"})
    public void beforeGroup() {
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void openRegPage() {
        Assert.assertEquals(registrationPage.openRegistrationPage(), REGISTRATION_PAGE_URl.getValue());
    }


    @Test
    public void createAnAccountPositive() throws InterruptedException {
        Assert.assertEquals(registrationPage.createAnAccount(), "Thank you for registering with Fake Online Clothing Store.");
    }

    @Test
    public void checkPageTitle() {
        softAssert.assertTrue(registrationPage.checkPageTitle());
        softAssert.assertEquals(registrationPage.getPageTitleText(), PAGE_TITLE.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkPersInfoText() {
        softAssert.assertTrue(registrationPage.checkPersInfoText());
        softAssert.assertEquals(registrationPage.getPersInfoText(), PERSONAL_INFO.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkSignInInfoText() {
        softAssert.assertTrue(registrationPage.checkSignInInfoText());
        softAssert.assertEquals(registrationPage.getSignInInfoText(), SIGN_IN_INFO.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkEmailValidation() throws InterruptedException {
        registrationPage.invalidEmailReg();
        softAssert.assertTrue(registrationPage.checkEmailErrorMessage());
        softAssert.assertEquals(registrationPage.getEmailErrorMessage(), INVALID_EMAIL_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutFirstName() throws InterruptedException {
        registrationPage.regWithOutFirstName();
        softAssert.assertTrue(registrationPage.checkFirstNameErrorMessage());
        softAssert.assertEquals(registrationPage.getFirstNameErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutLastName() throws InterruptedException {
        registrationPage.regWithOutLastName();
        softAssert.assertTrue(registrationPage.checkLastNameErrorMessage());
        softAssert.assertEquals(registrationPage.getLastNameErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutEmail() throws InterruptedException {
        registrationPage.regWithOutEmail();
        softAssert.assertTrue(registrationPage.checkEmailErrorMessage());
        softAssert.assertEquals(registrationPage.getEmailErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }


    @Test
    public void checkRegWithPass() throws InterruptedException {
        registrationPage.regWithOutPass();
        softAssert.assertTrue(registrationPage.checkPassError());
        softAssert.assertEquals(registrationPage.getPassError(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertEquals(registrationPage.getConfirmPassError(), CONFIRM_PASS_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithConfirmPass() throws InterruptedException {
        registrationPage.regWithOutConfirmPass();
        softAssert.assertTrue(registrationPage.checkConfirmPassError());
        softAssert.assertEquals(registrationPage.getConfirmPassError(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test(groups = {"labels"})
    public void getText() throws InterruptedException {
        registrationPage.fillAllFields();
        printError("First Name:           " + registrationPage.getFirstNameText());
        printError("Last Name:            " + registrationPage.getLastNameText());
        printError("E-mail:               " + registrationPage.getEmailText());
        printError("Password:             " + registrationPage.getPassText());
        printError("Confirm Password:     " + registrationPage.getConfirmPssText());
        driver.navigate().refresh();
        softAssert.assertEquals(registrationPage.getFirstNameText(), "");
        softAssert.assertEquals(registrationPage.getLastNameText(), "");
        softAssert.assertEquals(registrationPage.getEmailText(), "");
        softAssert.assertEquals(registrationPage.getPassText(), "");
        softAssert.assertEquals(registrationPage.getConfirmPssText(), "");

    }

    @Test(groups = {"labels"})
    public void checkLabels() {
        softAssert.assertTrue(registrationPage.checkFirstNameText());
        softAssert.assertTrue(registrationPage.checkLastNameText());
        softAssert.assertTrue(registrationPage.checkEmailText());
        softAssert.assertTrue(registrationPage.checkPassText());
        softAssert.assertTrue(registrationPage.checkConfirmPassText());
        softAssert.assertTrue(registrationPage.checkCreateButton());
        softAssert.assertAll();
    }

    @Test
    public void checkPassType(){
        softAssert.assertEquals(registrationPage.getPassFieldType(), "password");
        softAssert.assertEquals(registrationPage.getConfirmPassFieldType(), "password");
        softAssert.assertAll();
    }

    @Test
    public void checkConfirmPass() throws InterruptedException {
        registrationPage.regWithDifferentPass();
        Assert.assertEquals(registrationPage.getConfirmPassError(), CONFIRM_PASS_ERROR.getValue());
    }

    @Test
    public void checkRegWithUsedEmail() throws InterruptedException {
        registrationPage.regWithUsedEmail();
        Thread.sleep(1000);
        softAssert.assertTrue(registrationPage.checkUsedEmailError());
        softAssert.assertEquals(registrationPage.getUsedEmailErrorText(), USED_EMAIL_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test(groups = {"password"})
    public void checkWeakPassStrength() throws InterruptedException {
        registrationPage.checkWeakPassStrength();
        Assert.assertEquals(registrationPage.getPassStrengthColor(), WEAK_PASS_COLOR.getValue());
    }

    @Test(groups = {"password"})
    public void checkMediumPassStrength() throws InterruptedException {
        registrationPage.checkMediumPassStrength();
        Assert.assertEquals(registrationPage.getPassStrengthColor(), MEDIUM_PASS_COLOR.getValue());
    }

    @Test(groups = {"password"})
    public void checkStrongPassStrength() throws InterruptedException {
        registrationPage.checkStrongPassStrength();
        Assert.assertEquals(registrationPage.getPassStrengthColor(), STRONG_PASS_COLOR.getValue());
    }

    @Test(groups = {"password"})
    public void checkVeryStrongPassStrength() throws InterruptedException {
        registrationPage.checkVeryStrongPassStrength();
        Assert.assertEquals(registrationPage.getPassStrengthColor(), VERY_STRONG_PASS_COLOR.getValue());
    }

}
