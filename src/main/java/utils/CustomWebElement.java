package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CustomWebDriver.getDriver;

public class CustomWebElement {
    static WebDriver driver = getDriver();

    public static void click(WebElement element){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sendKey(WebElement element, String text){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void hover(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        mouseOverHome.perform();
    }

    public static String getText(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static void printError(String str){
        System.out.println("\u001B[31m" + str +  "\u001B[0m");
    }
}
