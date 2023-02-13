import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Constants.RegistrationPageEnum.*;
import static utils.CustomWebDriver.getDriver;
import static utils.CustomWebElement.printInfo;

//        Check if the user able to sign up or register by entering the valid data in all the fields.
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
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void init() {
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.open();
        getDriver().navigate().refresh();
    }


    @Test
    public void openRegPage() {
        Assert.assertEquals(registrationPage.openRegistrationPage(), REGISTRATION_PAGE_URl.getValue());
    }


    @Test
    public void createAnAccountPositive() {
        Assert.assertEquals(registrationPage.createAnAccount(), "Thank you for registering with Fake Online Clothing Store.");
    }

    @Test
    public void checkLabels() {
        softAssert.assertTrue(registrationPage.checkPageTitle());
        softAssert.assertEquals(registrationPage.getPageTitleText(), PAGE_TITLE.getValue());
        softAssert.assertTrue(registrationPage.checkPersInfoText());
        softAssert.assertEquals(registrationPage.getPersInfoText(), PERSONAL_INFO.getValue());
        softAssert.assertTrue(registrationPage.checkSignInInfoText());
        softAssert.assertEquals(registrationPage.getSignInInfoText(), SIGN_IN_INFO.getValue());
        softAssert.assertTrue(registrationPage.checkFirstNameText());
        softAssert.assertTrue(registrationPage.checkLastNameText());
        softAssert.assertTrue(registrationPage.checkEmailText());
        softAssert.assertTrue(registrationPage.checkPassText());
        softAssert.assertTrue(registrationPage.checkConfirmPassText());
        softAssert.assertTrue(registrationPage.checkCreateButton());
        softAssert.assertAll();
    }

    @Test
    public void checkEmailValidation() {
        registrationPage.invalidEmailReg();
        softAssert.assertTrue(registrationPage.checkEmailErrorMessage());
        softAssert.assertEquals(registrationPage.getEmailErrorMessage(), INVALID_EMAIL_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutFirstName() {
        registrationPage.regWithOutFirstName();
        softAssert.assertTrue(registrationPage.checkFirstNameErrorMessage());
        softAssert.assertEquals(registrationPage.getFirstNameErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutLastName() {
        registrationPage.regWithOutLastName();
        softAssert.assertTrue(registrationPage.checkLastNameErrorMessage());
        softAssert.assertEquals(registrationPage.getLastNameErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithOutEmail() {
        registrationPage.regWithOutEmail();
        softAssert.assertTrue(registrationPage.checkEmailErrorMessage());
        softAssert.assertEquals(registrationPage.getEmailErrorMessage(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }


    @Test
    public void checkRegWithPass() {
        registrationPage.regWithOutPass();
        softAssert.assertTrue(registrationPage.checkPassError());
        softAssert.assertEquals(registrationPage.getPassError(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertEquals(registrationPage.getConfirmPassError(), CONFIRM_PASS_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkRegWithConfirmPass() {
        registrationPage.regWithOutConfirmPass();
        softAssert.assertTrue(registrationPage.checkConfirmPassError());
        softAssert.assertEquals(registrationPage.getConfirmPassError(), EMPTY_FIELD_ERROR.getValue());
        softAssert.assertAll();
    }

    @Test
    public void getTexts() {
        registrationPage.fillAllFields();
        printInfo("First Name:           " + registrationPage.getFirstNameText());
        printInfo("Last Name:            " + registrationPage.getLastNameText());
        printInfo("E-mail:               " + registrationPage.getEmailText());
        printInfo("Password:             " + registrationPage.getPassText());
        printInfo("Confirm Password:     " + registrationPage.getConfirmPssText());
        getDriver().navigate().refresh();
        softAssert.assertEquals(registrationPage.getFirstNameText(), "");
        softAssert.assertEquals(registrationPage.getLastNameText(), "");
        softAssert.assertEquals(registrationPage.getEmailText(), "");
        softAssert.assertEquals(registrationPage.getPassText(), "");
        softAssert.assertEquals(registrationPage.getConfirmPssText(), "");

    }


    @Test
    public void checkPassType() {
        softAssert.assertEquals(registrationPage.getPassFieldType(), "password");
        softAssert.assertEquals(registrationPage.getConfirmPassFieldType(), "password");
        softAssert.assertAll();
    }

    @Test
    public void checkConfirmPass() {
        registrationPage.regWithDifferentPass();
        Assert.assertEquals(registrationPage.getConfirmPassError(), CONFIRM_PASS_ERROR.getValue());
    }

    @Test
    public void checkRegWithUsedEmail() {
        registrationPage.regWithUsedEmail();
        Assert.assertEquals(registrationPage.getUsedEmailErrorText(), USED_EMAIL_ERROR.getValue());
    }

    @Test
    public void checkPassStrengths() {
        SoftAssert softAssert = new SoftAssert();
        registrationPage.checkWeakPassStrength();
        softAssert.assertEquals(registrationPage.getPassStrengthColor(), WEAK_PASS_COLOR.getValue());
        registrationPage.checkMediumPassStrength();
        softAssert.assertEquals(registrationPage.getPassStrengthColor(), MEDIUM_PASS_COLOR.getValue());
        registrationPage.checkStrongPassStrength();
        softAssert.assertEquals(registrationPage.getPassStrengthColor(), STRONG_PASS_COLOR.getValue());
        registrationPage.checkVeryStrongPassStrength();
        softAssert.assertEquals(registrationPage.getPassStrengthColor(), VERY_STRONG_PASS_COLOR.getValue());
        softAssert.assertAll();
    }


}
