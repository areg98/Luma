import Pages.HomePageWithSignIn;
import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static Enums.RegistrationPageEnum.REGISTRATION_PAGE_URl;
import static Enums.SignInPageEnum.*;
import static utils.CustomWebDriver.getDriver;

public class SignInTest extends BaseTest{
    SignInPage signInPage;
    HomePageWithSignIn homePageWithSignIn;
    @BeforeMethod
    public void before(){
         signInPage = new SignInPage(getDriver());
        homePageWithSignIn = new HomePageWithSignIn(getDriver());
    }

    @Test
    public void validLogin() throws InterruptedException {
        signInPage.validSignIn();
        Assert.assertEquals(homePageWithSignIn.getLoggedInText(), LOGGED_IN_TEXT.getValue());
    }

    @Test
    public void inValidLogin() throws InterruptedException {
        Assert.assertEquals(signInPage.inValidSignIn(), INCORRECT_SIGN_IN_ERROR.getValue());
    }

    @Test
    public void emptyEmailLogin() throws InterruptedException {
        Assert.assertEquals(signInPage.emptyEmailSignIn(), EMPTY_EMAIL_ERROR.getValue());
    }

    @Test
    public void emptyPassLogin() throws InterruptedException {
        Assert.assertEquals(signInPage.emptyPassSignIn(), EMPTY_PASS_ERROR.getValue());
    }


    @Test
    public void checkBaseText() throws InterruptedException {
        Assert.assertEquals(signInPage.getBaseText(), BASE_TEXT.getValue());
    }

    @Test
    public void checkLoginText(){
        Assert.assertEquals(signInPage.getLoginText(), LOGIN_TEXT.getValue());
    }

    @Test
    public void checkRegisteredUserText(){
        Assert.assertEquals(signInPage.getRegisteredUserTest(), REG_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkNewCustomerText(){
        Assert.assertEquals(signInPage.getNewCustomerText(), NEW_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkCreateAnAccountButton(){
        signInPage.clickOnCreateAnAccountButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), REGISTRATION_PAGE_URl.getValue());
    }


}
