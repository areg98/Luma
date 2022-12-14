package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomWebDriver {
    static WebDriver driver = null;

    private static ChromeOptions setOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static WebDriver getDriver(){
        if (driver == null) driver = new ChromeDriver(setOptions());
        return driver;
    }

    public static void setDriver(WebDriver driver){
       CustomWebDriver.driver = driver;
    }
}
