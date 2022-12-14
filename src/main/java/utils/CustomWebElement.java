package utils;

import org.openqa.selenium.WebElement;

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

    public static void printError(String str){
        System.out.println("\u001B[32m" + str + "\u001B[0m");
    }
}
