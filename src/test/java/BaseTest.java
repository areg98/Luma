import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import utils.Configurations;

import java.time.Duration;

import static utils.CustomWebDriver.getDriver;
import static utils.CustomWebDriver.setDriver;

public class BaseTest {
    private static WebDriver driver;
    private static String siteUrl = Configurations.URL;


    @BeforeMethod
    public static void beforeMethod() {
        driver = getDriver();
//        driver.get(Configurations.URL);
//        basePage.get();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
        setDriver(null);
    }

    @BeforeGroups({"password", "labels"})
    public static void beforeGroups() {
        driver = getDriver();
    }

    @AfterGroups({"password", "labels"})
    public static void afterGroups() {
        if (driver != null) {
            driver.quit();
        }
        setDriver(null);
    }
}
