package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.CustomWebElement.click;

public class Header {
    private WebDriver driver;
    @FindBy(className = "authorization-link")
    private WebElement signInButton;
    @FindBy(linkText = "Create an Account")
    private WebElement regButton;
    @FindBy(className = "logo")
    private WebElement lumaLogo;
    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(css = "[class='action showcart']")
    private WebElement cartButton;
    @FindBy(id = "ui-id-6")
    private WebElement menu;
    @FindBy(id = "ui-id-3")
    private WebElement whatsNew;
//    private WebElement women;
//    private List<WebElement> womenSectionList;
//    private List<WebElement> womenTopsSectionList;
//    private WebElement womenTopsJackets;
//    private WebElement womenTopsHoodiesSweatshirts;
//    private WebElement womenTopsTees;
//    private WebElement womenTopsBrasTanks;
//    private WebElement womenBottoms;
//    private WebElement womenBottomsPants;
//    private WebElement womenBottomsShorts;
//    private WebElement headerMenu;
//    private List<WebElement> headerMenuList;


    // Todo add all WebElements from header menu
    // Todo add click method for all that WebElements


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInButton() {
        click(signInButton);
    }

    public void clickOnRegButton() {
        click(regButton);
    }

    public void clickOnCartButton() {
        click(cartButton);
    }

    public void clickOnLumaLogo() {
        click(lumaLogo);
    }

    public void clickOnWhatsNew() {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(menu)
                .build();
        mouseOverHome.perform();
        click(whatsNew);

    }


//    public void clickOnWomen() {
//        click(headerMenuList.get(1));
//    }
//
//    public void clickOnWomenTops() {
//        click(womenTops);
//    }
//
//    public void clickOnWomenTopsJackets() {
//        click(womenTopsJackets);
//    }
//
//    public void clickOnWomenTopsHoodies() {
//        click(womenTopsHoodiesSweatshirts);
//    }
//
//    public void clickOnWomenTopsTees() {
//        click(womenTopsTees);
//    }
//
//    public void clickOnWomenTopsBras(){
//        click(womenTopsBrasTanks);
//    }
//
//    public void clickOnWomenBottom(){
//        click(womenBottoms);
//    }
//
//    public void clickOnWomenBottomsPants(){
//        click(womenBottomsPants);
//    }
//
//    public void clickOnWomenBottomsShorts(){
//        click(womenBottomsShorts);
//    }


}
