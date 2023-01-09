package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomWebDriver {
    static WebDriver driver = null;

    private static ChromeOptions setChromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    private static FirefoxOptions setFirefoxOptions(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        return options;
    }

    private static EdgeOptions setEdgeOptions(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static WebDriver getDriver(){
        if (Configurations.BROWSER_TYPE.equalsIgnoreCase("chrome") && driver == null) {
            driver = new ChromeDriver(setChromeOptions());
        }
        else if (Configurations.BROWSER_TYPE.equalsIgnoreCase("firefox") && driver == null) {
//            driver = new FirefoxDriver(setFirefoxOptions());
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(Configurations.BROWSER_TYPE.equalsIgnoreCase("edge") && driver == null){
            driver = new EdgeDriver(setEdgeOptions());
        }
        return driver;
    }

    public static void setDriver(WebDriver driver){
       CustomWebDriver.driver = driver;
    }
}
