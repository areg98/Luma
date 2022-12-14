import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.CustomWebDriver.*;

public class BaseTest {
    private static WebDriver driver;
    private static String siteUrl = "https://magento.softwaretestingboard.com/";
    @BeforeMethod
    public static void beforeMethod() throws InterruptedException {
        driver = getDriver();
        driver.get(siteUrl);
        Thread.sleep(2000);
    }

    @AfterMethod
    public static void afterMethod(){
        if (driver != null)
        driver.quit();
        setDriver(null);
    }
}
