package Enums;

public enum RegistrationPageEnum {

    REGISTRATION_PAGE_URl("https://magento.softwaretestingboard.com/customer/account/create/");

    private String value;

    RegistrationPageEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
