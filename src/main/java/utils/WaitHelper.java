package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CustomExpectedCondition.*;
import static utils.CustomWebDriver.getDriver;

//        ExpectedCondition < WebElement > elementToBeClickable(By locator)
//        ExpectedCondition < Boolean > elementToBeSelected(By locator)
//        ExpectedCondition < WebElement > presenceOfElementLocated(By locator)
//        ExpectedCondition < Boolean > titleContains(String title)
//        ExpectedCondition < Boolean > titleIs(String title)
//        ExpectedCondition < Boolean > urlContains(String fraction)
//        ExpectedCondition < Boolean > urlToBe(String url)
//        ExpectedCondition < WebElement > visibilityOfElementLocated(By locator)

public class WaitHelper {

    private static final int TIME_OUT = 10;
    static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIME_OUT));

    public static void waitUntilElementToBeClickable(WebElement element) {
        wait.until(toBeAppeared(element));
        wait.until(toBeClickable(element));
    }

    public static void waitUntilTextAppeared(WebElement element) {
        wait.until(textToBeDisplayed(element));
    }

    public static void waitUntilElementAppeared(WebElement element) {
        wait.until(toBeAppeared(element));
    }

//    public static void waitUntilBeforeAppeared(WebElement element) {
//        wait.until(beforeElement(element));
//    }

}
