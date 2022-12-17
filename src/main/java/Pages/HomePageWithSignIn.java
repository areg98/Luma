package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePageWithSignIn {
    private WebDriver driver;
    @FindBy(css = "[class='logged-in']")
    private WebElement loggedInText;

    public HomePageWithSignIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoggedInText() throws InterruptedException {
        Thread.sleep(2000);
        return loggedInText.getText();
    }
}
