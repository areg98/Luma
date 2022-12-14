import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utils.CustomWebDriver.getDriver;

public class HomePageTest extends BaseTest {

    @Test
    public void checkMainPromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomeMainPromo());
    }

    @Test
    public void checkPantsPromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomePantsPromo());
    }

    @Test
    public void checkTeesPromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomeTeesPromo());
    }

    @Test
    public void checkErinPromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomeErinPromo());
    }

    @Test
    public void checkPerformancePromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomePerformancePromo());
    }

    @Test
    public void checkEcoPromo(){
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHomeEcoPromo());
    }
}
