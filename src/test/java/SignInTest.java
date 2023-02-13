import Pages.HomePageWithSignIn;
import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static Constants.RegistrationPageEnum.REGISTRATION_PAGE_URl;
import static Constants.SignInPageEnum.*;
import static utils.CustomWebDriver.getDriver;

public class SignInTest extends BaseTest {
    SignInPage signInPage;
    HomePageWithSignIn homePageWithSignIn;

    @BeforeMethod
    public void init() {
        signInPage = new SignInPage(getDriver());
        homePageWithSignIn = new HomePageWithSignIn(getDriver());
        signInPage.open();
    }

    @Test
    public void validLogin() {
        signInPage.validSignIn();
        Assert.assertEquals(homePageWithSignIn.getLoggedInText(), LOGGED_IN_TEXT.getValue());
    }

    @Test
    public void inValidLogin() {
        Assert.assertEquals(signInPage.inValidSignIn(), INCORRECT_SIGN_IN_ERROR.getValue());
    }

    @Test
    public void emptyEmailLogin() {
        Assert.assertEquals(signInPage.emptyEmailSignIn(), EMPTY_EMAIL_ERROR.getValue());
    }

    @Test
    public void emptyPassLogin() {
        Assert.assertEquals(signInPage.emptyPassSignIn(), EMPTY_PASS_ERROR.getValue());
    }


    @Test
    public void checkBaseText() {
        Assert.assertEquals(signInPage.getBaseText(), BASE_TEXT.getValue());
    }

    @Test
    public void checkLoginText() {
        Assert.assertEquals(signInPage.getLoginText(), LOGIN_TEXT.getValue());
    }

    @Test
    public void checkRegisteredUserText() {
        Assert.assertEquals(signInPage.getRegisteredUserTest(), REG_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkNewCustomerText() {
        Assert.assertEquals(signInPage.getNewCustomerText(), NEW_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkCreateAnAccountButton() {
        signInPage.clickOnCreateAnAccountButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), REGISTRATION_PAGE_URl.getValue());
    }


}
