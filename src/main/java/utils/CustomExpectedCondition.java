package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static utils.CustomWebElement.printError;

public class CustomExpectedCondition {

    public static ExpectedCondition toBeAppeared(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return (element != null && element.isDisplayed());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBeDisplayed(WebElement element) {
      return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return !element.getText().isEmpty() && element.isDisplayed();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> toBeClickable(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return element != null && element.isEnabled();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

//    public static ExpectedCondition<Boolean> beforeElement(WebElement element) {
//        return new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                try {
//                    printError("waiting...");
//                    String script = "return window.getComputedStyle(document.querySelector('." + element + "'),'::before').getPropertyValue('color')";
//                    JavascriptExecutor js = (JavascriptExecutor) driver;
//                    String name = js.executeScript(script).toString();
//                    return name.isEmpty();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    printError("not found");
//                    printError(element.toString());
//                    return false;
//                }
//            }
//        };
//    }



}
