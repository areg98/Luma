package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static utils.CustomWebElement.*;

public class HomePage {
    private static WebDriver driver;
    private WebElement homeMainPromo;
    private WebElement homePantsPromo;
    private WebElement homeShirtsPromo;
    private WebElement homePerformancePromo;
    private WebElement homeEcoPromo;
    private WebElement homeErinPromo;
    private WebElement signIn;
    private static String siteUrl = "https://magento.softwaretestingboard.com/";

    public HomePage(WebDriver driver){
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements(){
        homeMainPromo  = driver.findElement(By.cssSelector("[class='block-promo home-main']"));
        homePantsPromo = driver.findElement(By.cssSelector("[class = 'block-promo home-pants']"));
        homeShirtsPromo = driver.findElement(By.cssSelector("[class='block-promo home-t-shirts']"));
        homePerformancePromo = driver.findElement(By.cssSelector("[class='block-promo home-performance']"));
        homeEcoPromo = driver.findElement(By.cssSelector("[class='block-promo home-eco']"));
        homeErinPromo = driver.findElement(By.cssSelector("[class = 'block-promo home-erin']"));
        signIn = driver.findElement(By.className("authorization-link"));
    }

    public void clickOnSignInButton(){
        click(signIn);
    }


    public  boolean checkHomeMainPromo(){
        click(homeMainPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/yoga-new.html"))
            return true;
        else return false;
    }

    public boolean checkHomePantsPromo(){
        click(homePantsPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/promotions/pants-all.html"))
            return true;
        else return false;
    }

    public boolean checkHomeTeesPromo(){
        click(homeShirtsPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/promotions/tees-all.html"))
            return true;
        else return false;
    }

    public boolean checkHomePerformancePromo(){
        click(homePerformancePromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/performance-fabrics.html"))
            return true;
        else return false;
    }

    public boolean checkHomeEcoPromo(){
        click(homeEcoPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        driver.quit();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/eco-friendly.html"))
            return true;
        else return false;
    }

    public boolean checkHomeErinPromo(){
        click(homeErinPromo);
        String currentUrl = driver.getCurrentUrl();
        driver.navigate().back();
        if (currentUrl.equals("https://magento.softwaretestingboard.com/collections/erin-recommends.html"))
            return true;
        else return false;
    }

}
