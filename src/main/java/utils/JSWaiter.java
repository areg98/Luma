package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CustomWebDriver.getDriver;


public class JSWaiter {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    private static final int TIME_OUT = 10;


    //Get the driver
    public static void setDriver() {
        jsWaitDriver = getDriver();
        jsWait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    private void ajaxComplete() {
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    private void waitForJQueryLoad() {
        setDriver();
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
                    .executeScript("return jQuery.active") == 0);
            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public static void waitUntilJSReady() {
        setDriver();
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


    public static boolean waitForJQueryToLoad() {
        setDriver();
        WebDriverWait wait = new WebDriverWait(jsWaitDriver, Duration.ofSeconds(TIME_OUT));
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad);
    }

}
