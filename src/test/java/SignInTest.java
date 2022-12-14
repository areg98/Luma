import Pages.BasePage;
import Pages.Header;
import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Enums.SignInPageEnum.*;
import static Enums.RegistrationPageEnum.*;
import static utils.CustomWebDriver.getDriver;
import Pages.BasePage.*;

public class SignInTest extends BaseTest{

    @Test
    public void validLogin() throws InterruptedException {
       SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.validSignIn(), LOGGED_IN_TEXT.getValue());
    }

    @Test
    public void inValidLogin() throws InterruptedException { // Todo change to checking with error message
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.inValidSignIn(), NOT_LOGGED_IN_TEXT.getValue());
    }

    @Test
    public void emptyLogin() throws InterruptedException { //Todo change to checking with error message
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.emptySignIn(), NOT_LOGGED_IN_TEXT.getValue());
    }

    @Test
    public void checkBaseText() throws InterruptedException {
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.getBaseText(), BASE_TEXT.getValue());
    }

    @Test
    public void checkLoginText(){
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.getLoginText(), LOGIN_TEXT.getValue());
    }

    @Test
    public void checkRegisteredUserText(){
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.getRegisteredUserTest(), REG_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkNewCustomerText(){
        SignInPage signInPage = new SignInPage(getDriver());
        Assert.assertEquals(signInPage.getNewCustomerText(), NEW_CUSTOMER_TEXT.getValue());
    }

    @Test
    public void checkCreateAnAccountButton(){
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.clickOnCreateAnAccountButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), REGISTRATION_PAGE_URl.getValue());
    }
}
