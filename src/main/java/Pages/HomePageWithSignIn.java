package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CustomWebElement.getText;

public class HomePageWithSignIn {
    private WebDriver driver;
    @FindBy(className = "logged-in")
    private WebElement loggedInText;

    public HomePageWithSignIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoggedInText(){
        return getText(loggedInText);
    }
}
