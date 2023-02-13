import Pages.MyAccount;
import Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Constants.MyAccountEnum.*;
import static Constants.URL.*;
import static utils.CustomWebDriver.getDriver;

public class MyAccountTest extends BaseTest {

    MyAccount myAccount;
    SoftAssert softAssert = new SoftAssert();;

    @BeforeMethod
    public void init(){
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.open();
        signInPage.validSignIn();
        myAccount = new MyAccount(getDriver());
        myAccount.open();
    }

    @Test
    public void checkLabels(){
        softAssert.assertEquals(myAccount.getPageTitleText(), MY_ACCOUNT_TITLE_TEXT.getValue());
        softAssert.assertEquals(myAccount.getAccountInfoTitleText(), MY_ACCOUNT_INFO_TITLE_TEXT.getValue());
        softAssert.assertEquals(myAccount.getAddressBookTitleText(), MY_ACCOUNT_ADDRESS_BOOK_TITLE_TEXT.getValue());
        softAssert.assertEquals(myAccount.getContactInfoTitleText(), MY_ACCOUNT_CONTACT_INFO_TITLE_TEXT.getValue());
        softAssert.assertEquals(myAccount.getBillingAddressTitleText(), MY_ACCOUNT_BILLING_ADDRESS_TITLE_TEXT.getValue());
        softAssert.assertAll();
    }

    @Test
    public void checkEditBtns(){
        myAccount.clickOnUserInfoEditBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), USER_INFO_EDIT_URL.getValue());
        getDriver().navigate().back();
        myAccount.clickOnPassChangeBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), CHANGE_PASS_URL.getValue());
        getDriver().navigate().back();
        myAccount.clickOnNewslettersEditBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), NEWSLETTERS_EDIT_URL.getValue());
        getDriver().navigate().back();
        myAccount.clickOnManageAddressBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), NEW_ADDRESS_URL.getValue());
        getDriver().navigate().back();
        myAccount.clickOnBillingAddressEditBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), ADDRESS_EDIT_URL.getValue());
        getDriver().navigate().back();
        myAccount.clickOnShippingAddressEditBtn();
        softAssert.assertEquals(getDriver().getCurrentUrl(), ADDRESS_EDIT_URL.getValue());
        softAssert.assertAll();
    }

    @Test
    public void openMyOrders(){
        myAccount.clickOnMyOrders();
        Assert.assertEquals(getDriver().getCurrentUrl(), MY_ORDERS_URL.getValue());
    }

    @Test
    public void openMyDownloadableProducts(){
        myAccount.clickOnMyDownloadableProducts();
        Assert.assertEquals(getDriver().getCurrentUrl(), MY_DOWNLOADABLE_PRODUCTS_URL.getValue() );
    }

    @Test
    public void openMyWishList(){
        myAccount.clickOnMyWishList();
        Assert.assertEquals(getDriver().getCurrentUrl(), MY_WISH_LIST_URL.getValue() );
    }

    @Test
    public void openAddressBook(){
        myAccount.clickOnAddressBook();
        Assert.assertEquals(getDriver().getCurrentUrl(), NEW_ADDRESS_URL.getValue() );
    }

    @Test
    public void openAccountInformation(){
        myAccount.clickOnAccountInformation();
        Assert.assertEquals(getDriver().getCurrentUrl(), USER_INFO_EDIT_URL.getValue() );
    }

    @Test
    public void openStoredPaymentMethods(){
        myAccount.clickOnStoredPaymentMethods();
        Assert.assertEquals(getDriver().getCurrentUrl(), STORED_PAYMENT_METHODS_URL.getValue() );
    }

    @Test
    public void openMyProductReviews(){
        myAccount.clickOnMyProductReviews();
        Assert.assertEquals(getDriver().getCurrentUrl(), MY_PRODUCTS_REVIEWS_URL.getValue() );
    }

    @Test
    public void openNewsletterSubscription(){
        myAccount.clickOnNewsletterSubscription();
        Assert.assertEquals(getDriver().getCurrentUrl(), NEWSLETTERS_EDIT_URL.getValue() );
    }

}
