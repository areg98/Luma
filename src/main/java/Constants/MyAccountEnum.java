package Constants;

public enum MyAccountEnum {

    MY_ACCOUNT_TITLE_TEXT("My Account"),
    MY_ACCOUNT_INFO_TITLE_TEXT("Account Information"),
    MY_ACCOUNT_ADDRESS_BOOK_TITLE_TEXT("Address Book Manage Addresses"),
    MY_ACCOUNT_CONTACT_INFO_TITLE_TEXT("Contact Information"),
    MY_ACCOUNT_BILLING_ADDRESS_TITLE_TEXT("Default Billing Address"),
    MY_ACCOUNT_SHIPPING_ADDRESS_TITLE_TEXT("Default Shipping Address");



    private String value;

    MyAccountEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
