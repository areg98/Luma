import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.CustomWebDriver.*;

public class BaseTest {
    //    private static WebDriver driver;
//    private static String siteUrl = Configurations.URL;
//    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
        setDriver();
    }

//    public WebDriver getThreadLocalDriver() {
//        return threadLocalDriver.get();
//    }

    @AfterMethod
    public void afterMethod() {
        if (getDriver() != null) {
            quitDriver();
            removeDriverThreadLocal();
        }
    }

}
