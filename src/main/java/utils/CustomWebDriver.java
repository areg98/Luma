package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

import static utils.Configurations.BROWSER_TYPE;


public class CustomWebDriver {

    private static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public CustomWebDriver() {
    }

    private static ChromeOptions chromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    private static EdgeOptions edgeOptions() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        return edgeOptions;
    }

    public static void removeDriverThreadLocal() {
        threadLocal.remove();
    }

    public static WebDriver getDriver() {
        return Objects.requireNonNull(threadLocal.get());
    }

    public static void quitDriver() {
        getDriver().quit();
    }

    public static void setDriver() {
        switch (BROWSER_TYPE) {
            case "chrome" -> driver = new ChromeDriver(chromeOptions());
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver(edgeOptions());
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            default -> CustomWebElement.printInfo("WRONG BROWSER NAME");
        }
        threadLocal.set(Objects.requireNonNull(driver));
        CustomWebElement.printInfo("Waiting for driver");
        CustomWebDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}