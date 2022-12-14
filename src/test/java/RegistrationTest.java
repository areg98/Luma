import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.CustomWebDriver.getDriver;

public class RegistrationTest extends BaseTest {


    @Test(priority = 0)
    public void openRegPage(){
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        Assert.assertEquals(registrationPage.openRegistrationPage(), "https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @Test(priority = 1) //Todo this case is always fail
    public void createAnAccountPositive() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        Assert.assertEquals(registrationPage.createAnAccount(), "Thank you for registering with Fake Online Clothing Store.");
    }

}
