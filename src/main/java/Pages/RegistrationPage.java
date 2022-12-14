package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Enums.SignInPageEnum.*;
import static utils.CustomWebElement.*;
import java.util.Random;

public class RegistrationPage {
    private WebDriver driver;
    private WebElement regButton;
    private WebElement firstName;
    private WebElement lastName;
    private  WebElement email;
    private WebElement pass;
    private WebElement confirmPass;
    private WebElement createAnAccountButton;
    private  WebElement successMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        initWebElements();
    }

    public void initWebElements() {
        try {
            regButton = driver.findElement(By.linkText("Create an Account"));
            firstName = driver.findElement(By.id("firstname"));
            lastName = driver.findElement(By.id("lastname"));
            email = driver.findElement(By.id("email_address"));
            pass = driver.findElement(By.id("password"));
            confirmPass = driver.findElement(By.id("password-confirmation"));
            createAnAccountButton = driver.findElement(By.cssSelector("[class='action submit primary']"));
            successMessage = driver.findElement(By.cssSelector("[class='message-success success message']"));
        }catch (NoSuchElementException e){

        }
    }

    public  String generateRandomPass() {
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

    public String generateRandomMail() {
        String mail = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            mail = mail + (char) random.nextInt(97, 122);
        }
        mail = mail + "@mail.com";
        return mail;
    }

    public String openRegistrationPage() {
        click(regButton);
        return driver.getCurrentUrl();
    }

    public String createAnAccount() throws InterruptedException {
        click(regButton);
        initWebElements();
        sendKey(firstName, FIRST_NAME.getValue());
        sendKey(lastName, LAST_NAME.getValue());
        String e_mail = generateRandomMail();
        sendKey(email, e_mail);
        String password = generateRandomPass();
        sendKey(pass, password);
        sendKey(confirmPass, password);
        click(createAnAccountButton);
        Thread.sleep(1000);
        initWebElements();
        Thread.sleep(2000);
        return successMessage.getText();

    }
}
