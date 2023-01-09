package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utils.LoadableComponent;

import static utils.CustomWebDriver.getDriver;
import static utils.CustomWebElement.click;
import static utils.WaitHelper.*;

public class HomePage extends BasePage {
    private static WebDriver driver;
    @FindBy(css = "[class='block-promo home-main']")
    private WebElement homeMainPromo;
    @FindBy(css = "[class = 'block-promo home-pants']")
    private WebElement homePantsPromo;
    @FindBy(css = "[class='block-promo home-t-shirts']")
    private WebElement homeShirtsPromo;
    @FindBy(css = "[class='block-promo home-performance']")
    private WebElement homePerformancePromo;
    @FindBy(css = "[class='block-promo home-eco']")
    private WebElement homeEcoPromo;
    @FindBy(css = "[class = 'block-promo home-erin']")
    private WebElement homeErinPromo;
    @FindBy(className = "authorization-link")
    private WebElement signIn;
    private static String siteUrl = "https://magento.softwaretestingboard.com/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkHomeMainPromo() {
        click(homeMainPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/yoga-new.html"))
            return true;
        else return false;
    }

    public boolean checkHomePantsPromo() {
        click(homePantsPromo);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/promotions/pants-all.html"))
            return true;
        else return false;
    }

    public boolean checkHomeTeesPromo() {
        click(homeShirtsPromo);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/promotions/tees-all.html"))
            return true;
        else return false;
    }

    public boolean checkHomePerformancePromo() {
        click(homePerformancePromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/performance-fabrics.html"))
            return true;
        else return false;
    }

    public boolean checkHomeEcoPromo() {
        click(homeEcoPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        driver.quit();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/eco-friendly.html"))
            return true;
        else return false;
    }

    public boolean checkHomeErinPromo() {
        click(homeErinPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/erin-recommends.html"))
            return true;
        else return false;
    }

    @Override
    protected void load() {
        driver.get(siteUrl);
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(homeShirtsPromo);
        } catch (Exception e) {
            throw new Error();
        }

    }

}