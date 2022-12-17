import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static utils.CustomWebDriver.getDriver;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void before(){
        homePage = new HomePage(getDriver());
    }

    @Test
    public void checkMainPromo(){
        Assert.assertTrue(homePage.checkHomeMainPromo());
    }

    @Test
    public void checkPantsPromo(){
        Assert.assertTrue(homePage.checkHomePantsPromo());
    }

    @Test
    public void checkTeesPromo(){
        Assert.assertTrue(homePage.checkHomeTeesPromo());
    }

    @Test
    public void checkErinPromo(){
        Assert.assertTrue(homePage.checkHomeErinPromo());
    }

    @Test
    public void checkPerformancePromo(){
        Assert.assertTrue(homePage.checkHomePerformancePromo());
    }

    @Test
    public void checkEcoPromo(){
        Assert.assertTrue(homePage.checkHomeEcoPromo());
    }
}
