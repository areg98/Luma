package Constants;

public enum SignInPageEnum {

    VALID_EMAIL("eublsn@mail.com"),
    VALID_PASSWORD("646Wm%Pf$"),
    INVALID_EMAIL("email@mail.com"),
    EMPTY_EMAIL_ERROR("This is a required field."),
    EMPTY_PASS_ERROR("This is a required field."),
    INCORRECT_SIGN_IN_ERROR("Incorrect CAPTCHA"),
    INVALID_PASSWORD("123456"),
    NOT_LOGGED_IN_TEXT("Default welcome msg!"),
    FIRST_NAME("Babken"),
    LAST_NAME("Babkenyan"),
    LOGGED_IN_TEXT("Welcome, " + FIRST_NAME.getValue() + " " + LAST_NAME.getValue() + "!"),
    BASE_TEXT("Customer Login"),
    REG_CUSTOMER_TEXT("Registered Customers"),
    LOGIN_TEXT("If you have an account, sign in with your email address."),
    NEW_CUSTOMER_TEXT("New Customers"),
    REG_TEXT("Creating an account has many benefits: check out faster, keep more than one address, track orders and more."),
    SIGN_URL("https://magento.softwaretestingboard.com/customer/account/login");


    private String value;

    SignInPageEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
