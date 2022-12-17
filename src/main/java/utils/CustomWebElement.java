package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CustomWebElement {

    public static void click(WebElement element){
        try {
        element.isDisplayed();
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sendKey(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void hover(WebDriver driver, WebElement element){
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        mouseOverHome.perform();
    }

    public static void printError(String str){
        System.out.println("\u001B[31m" + str +  "\u001B[0m");
    }
}
