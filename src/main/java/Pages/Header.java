package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;

import static utils.CustomWebElement.*;

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
    @FindBy(id = "ui-id-3")
    private WebElement whatsNew;
    @FindBy(id = "ui-id-4")
    private WebElement women;
    @FindBy(id = "ui-id-9")
    private WebElement womenTops;
    @FindBy(id = "ui-id-10")
    private WebElement womenBottoms;
    @FindBy(id = "ui-id-11")
    private WebElement womenTopsJackets;
    @FindBy(id = "ui-id-12")
    private WebElement womenTopsHoodiesSweatshirts;
    @FindBy(id = "ui-id-13")
    private WebElement womenTopsTees;
    @FindBy(id = "ui-id-14")
    private WebElement womenTopsBrasTanks;
    @FindBy(id = "ui-id-15")
    private WebElement womenBottomsPants;
    @FindBy(id = "ui-id-16")
    private WebElement womenBottomsShorts;
    @FindBy(id = "ui-id-5")
    private WebElement men;
    @FindBy(id = "ui-id-17")
    private WebElement menTops;
    @FindBy(id = "ui-id-19")
    private WebElement menTopsJackets;
    @FindBy(id = "ui-id-20")
    private WebElement menTopsHoodiesSweatshirts;
    @FindBy(id = "ui-id-21")
    private WebElement menTopsTees;
    @FindBy(id = "ui-id-22")
    private WebElement menTopsTanks;
    @FindBy(id = "ui-id-18")
    private WebElement menBottoms;
    @FindBy(id = "ui-id-23")
    private WebElement menBottomsPants;
    @FindBy(id = "ui-id-24")
    private WebElement menBottomsShorts;
    @FindBy(id = "ui-id-6")
    private WebElement gear;
    @FindBy(id = "ui-id-25")
    private WebElement gearBags;
    @FindBy(id = "ui-id-26")
    private WebElement gearFitnessEquipment;
    @FindBy(id = "ui-id-27")
    private WebElement gearWatches;
    @FindBy(id = "ui-id-7")
    private WebElement training;
    @FindBy(id = "ui-id-28")
    private WebElement trainingVideoDownload;
    @FindBy(id = "ui-id-8")
    private WebElement sale;




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
        hover(driver, women);
        click(whatsNew);
    }

    public void clickOnWomen() {
        click(women);
    }

    public void clickOnWomenTops() {
        hover(driver, women);
        click(womenTops);
    }

    public void clickOnWomenTopsJackets() throws InterruptedException {
        hover(driver, women);
        Thread.sleep(1000);
        hover(driver, womenTops);
        Thread.sleep(1000);
        click(womenTopsJackets);
    }

    public void clickOnWomenTopsHoodies() {
        hover(driver, women);
        hover(driver, womenTops);
        click(womenTopsHoodiesSweatshirts);
    }

    public void clickOnWomenTopsTees() {
        hover(driver, women);
        hover(driver, womenTops);
        click(womenTopsTees);
    }

    public void clickOnWomenTopsBras() {
        hover(driver, women);
        hover(driver, womenTops);
        click(womenTopsBrasTanks);
    }

    public void clickOnWomenBottom() {
        hover(driver, women);
        click(womenBottoms);
    }

    public void clickOnWomenBottomsPants() {
        hover(driver, women);
        hover(driver, womenBottoms);
        click(womenBottomsPants);
    }

    public void clickOnWomenBottomsShorts() {
        hover(driver, women);
        hover(driver, womenBottoms);
        click(womenBottomsShorts);
    }

    public void clickOnMen(){
        click(men);
    }

    public void clickOnMenTops(){
        hover(driver, men);
        click(menTops);
    }

    public void clickOnMenTopsJackets(){
        hover(driver, men);
        hover(driver, menTops);
        click(menTopsJackets);
    }

    public void clickOnMenTopsHoodiesSweatshirts(){
        hover(driver, men);
        hover(driver, menTops);
        click(menTopsHoodiesSweatshirts);
    }

    public void clickOnMenTopsTees(){
        hover(driver, men);
        hover(driver, menTops);
        click(menTopsTees);
    }

    public void clickOnMenTopsTanks(){
        hover(driver, men);
        hover(driver, menTops);
        click(menTopsTanks);
    }

    public void clickOnMenBottoms(){
        hover(driver, men);
        click(men);
    }

    public void clickOnMenBottomsPants(){
        hover(driver, men);
        hover(driver, menBottoms);
        click(menBottomsPants);
    }

    public void clickOnMenBottomsShorts(){
        hover(driver, men);
        hover(driver, menBottoms);
        click(menBottomsShorts);
    }

    public void clickOnGear(){
        click(gear);
    }

    public void clickOnGearBags(){
        hover(driver, gear);
        click(gearBags);
    }

    public void clickOnGearFitnessEquipment(){
        hover(driver, gear);
        click(gearFitnessEquipment);
    }

    public void clickOnGearWatches (){
        hover(driver, gear);
        click(gearWatches);
    }

    public void clickOnTrainings(){
        click(training);
    }

    public void clickOnTrainingVideoDownload(){
        hover(driver, training);
        click(trainingVideoDownload);
    }

    public void clickOnSale(){
        click(sale);
    }


}
