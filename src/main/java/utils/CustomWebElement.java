package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CustomWebDriver.getDriver;
import static utils.WaitHelper.*;

public class CustomWebElement {
    private static final int TIME_OUT = 10;
    static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIME_OUT));;


    public static void click(WebElement element){  // Todo check
        waitUntilElementToBeClickable(element);
        element.click();
    }

    public static void sendKey(WebElement element, String text){
        try {
            waitUntilElementAppeared(element);
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void hover(WebDriver driver, WebElement element){
        waitUntilElementAppeared(element);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        mouseOverHome.perform();
    }

    public static String getText(WebElement element){
        waitUntilTextAppeared(element);
        return element.getText();
    }

    public static void printInfo(Object text) {
        System.out.println("\u001B[32m" + text + "\u001B[0m");
    }

    public static String printError(String text) {
        throw new Error("\u001B[31m" + text + "\u001B[0m");
    }

}
