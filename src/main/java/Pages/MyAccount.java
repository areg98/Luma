package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.URL.*;
import static utils.CustomWebElement.*;
import static utils.WaitHelper.waitUntilElementAppeared;

public class MyAccount extends BasePage{
    private WebDriver driver;
    @FindBy(className = "page-title")
    private WebElement pageTitle;
    @FindBy(className = "block-title")
    private List<WebElement> accountBlockTitleList;
    @FindBy(className = "box-title")
    private List<WebElement> accountBoxTitleList;
    @FindBy(className = "box-content")
    private List<WebElement> accountBoxContentList;
    @FindBy(css = "[class='action edit']")
    private List<WebElement> actionEditBtnList;
    @FindBy(css = "[class = 'action change-password']")
    private WebElement passwordChangeBtn;
    @FindBy(css = "[class='nav item']")
    private List<WebElement> navigation;



    public MyAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    protected void load() {
        driver.get(MY_ACCOUNT_URL.getValue());
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(pageTitle);
        } catch (Exception e) {
            throw new Error();
        }

    }

    public String getPageTitleText(){
        return getText(pageTitle);
    }

    public String getAccountInfoTitleText(){
        return getText(accountBlockTitleList.get(2));
    }

    public String getAddressBookTitleText(){
        return getText(accountBlockTitleList.get(3));
    }

    public String getContactInfoTitleText(){
        return getText(accountBoxTitleList.get(0));
    }

    public String getBillingAddressTitleText(){
        return getText(accountBoxTitleList.get(2));
    }

    public void clickOnUserInfoEditBtn(){
        click(actionEditBtnList.get(0));
    }

    public void clickOnNewslettersEditBtn(){
        click(actionEditBtnList.get(1));
    }

    public void clickOnManageAddressBtn(){
        click(actionEditBtnList.get(2));
    }

    public void clickOnBillingAddressEditBtn(){
        click(actionEditBtnList.get(3));
    }

    public void clickOnShippingAddressEditBtn(){
        click(actionEditBtnList.get(4));
    }

    public void clickOnPassChangeBtn(){
        click(passwordChangeBtn);
    }

    public void clickOnMyOrders(){
        click(navigation.get(0));
    }

    public void clickOnMyDownloadableProducts(){
        click(navigation.get(1));
    }

    public void clickOnMyWishList(){
        click(navigation.get(2));
    }

    public void clickOnAddressBook(){
        click(navigation.get(4));
    }

    public void clickOnAccountInformation(){
        click(navigation.get(5));
    }

    public void clickOnStoredPaymentMethods(){
        click(navigation.get(6));
    }

    public void clickOnMyProductReviews() {
        click(navigation.get(8));
    }

    public void clickOnNewsletterSubscription(){
        click(navigation.get(9));
    }
}
