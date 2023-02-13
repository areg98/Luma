package Constants;

import java.util.Random;

public enum RegistrationPageEnum {

    REGISTRATION_PAGE_URl("https://magento.softwaretestingboard.com/customer/account/create/"),
    RANDOM_EMAIL(generateRandomMail()),
    RANDOM_PASS(generateRandomPass()),
    WEEK_PASS("123456"),
    MEDIUM_PASS("123aaAQ@"),
    STRONG_PASS("646Wm%Pf$"),
    VERY_STRONG_PASS("646Wm%Pf$aa"),
    INVALID_EMAIL("mail"),
    PERSONAL_INFO("Personal Information"),
    SIGN_IN_INFO("Sign-in Information"),
    PAGE_TITLE("Create New Customer Account"),
    INVALID_EMAIL_ERROR("Please enter a valid email address (Ex: johndoe@domain.com)."),
    EMPTY_FIELD_ERROR("This is a required field."),
    CONFIRM_PASS_ERROR("Please enter the same value again."),
    USED_EMAIL_ERROR("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."),
    WEAK_PASS_COLOR("#ffafae"),
    MEDIUM_PASS_COLOR("#ffd6b3"),
    STRONG_PASS_COLOR("#c5eeac"),
    VERY_STRONG_PASS_COLOR("#81b562");


    private String value;

    RegistrationPageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String generateRandomPass() {
        Random random = new Random();
        String pass = String.valueOf(random.nextInt(1000));
        for (int i = 0; i < 2; i++) {
            char upperCase = (char) random.nextInt(65, 90);
            char lowerCase = (char) random.nextInt(97, 122);
            char symbol = (char) random.nextInt(33, 40);
            pass = pass + upperCase + lowerCase + symbol;
        }
        return pass;
    }

    public static String generateRandomMail() {
        String mail = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            mail = mail + (char) random.nextInt(97, 122);
        }
        mail = mail + "@mail.com";
        return mail;
    }
}
