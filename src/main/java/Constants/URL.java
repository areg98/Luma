package Constants;

public enum URL {

    HOME_PAGE_URL("https://magento.softwaretestingboard.com/"),
    SIGN_URL("https://magento.softwaretestingboard.com/customer/account/login"),
    REGISTRATION_PAGE_URl("https://magento.softwaretestingboard.com/customer/account/create/"),

    MY_ACCOUNT_URL("https://magento.softwaretestingboard.com/customer/account/"),
    MY_ORDERS_URL("https://magento.softwaretestingboard.com/sales/order/history/"),
    MY_DOWNLOADABLE_PRODUCTS_URL("https://magento.softwaretestingboard.com/downloadable/customer/products/"),
    MY_WISH_LIST_URL("https://magento.softwaretestingboard.com/wishlist/"),
    NEW_ADDRESS_URL("https://magento.softwaretestingboard.com/customer/address/new/"),
    ADDRESS_EDIT_URL("https://magento.softwaretestingboard.com/customer/address/edit/"),
    USER_INFO_EDIT_URL("https://magento.softwaretestingboard.com/customer/account/edit/"),
    STORED_PAYMENT_METHODS_URL("https://magento.softwaretestingboard.com/vault/cards/listaction/"),
    MY_PRODUCTS_REVIEWS_URL("https://magento.softwaretestingboard.com/review/customer/"),
    NEWSLETTERS_EDIT_URL("https://magento.softwaretestingboard.com/newsletter/manage/"),
    CHANGE_PASS_URL("https://magento.softwaretestingboard.com/customer/account/edit/changepass/1/");


    private String value;

    URL(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
