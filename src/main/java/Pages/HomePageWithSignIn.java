package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageWithSignIn {
    private WebDriver driver;
    private WebElement loggedInText;

    public HomePageWithSignIn(WebDriver driver){
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements(){
        loggedInText = driver.findElement(By.className("logged-in"));
    }

    public String getLoggedInText(){
        return loggedInText.getText();
    }
}
