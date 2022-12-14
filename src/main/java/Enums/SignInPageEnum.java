package Enums;

public enum SignInPageEnum {

    VALID_EMAIL("tgakmp@mail.com"),
    VALID_PASSWORD("123Hh%Iu&"),
    INVALID_EMAIL("email@mail.com"),
    INVALID_PASSWORD("123456"),
    NOT_LOGGED_IN_TEXT("Default welcome msg!"),
    FIRST_NAME("name"),
    LAST_NAME("lastname"),
    LOGGED_IN_TEXT("Welcome, " + FIRST_NAME.getValue() + " " + LAST_NAME.getValue() + "!"),
    BASE_TEXT("Customer Login"),
    REG_CUSTOMER_TEXT("Registered Customers"),
    LOGIN_TEXT("If you have an account, sign in with your email address."),
    NEW_CUSTOMER_TEXT("New Customers"),
    REG_TEXT("Creating an account has many benefits: check out faster, keep more than one address, track orders and more.");


    private String value;

    SignInPageEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
