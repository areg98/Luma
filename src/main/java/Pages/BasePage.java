package Pages;

import utils.LoadableComponent;

import static utils.CustomWebDriver.getDriver;
import static utils.JSWaiter.*;

public class BasePage extends LoadableComponent<BasePage> {

    private Header header;
    private Footer footer;
    private HeaderWithSignIn headerWithoutSignIn = new HeaderWithSignIn(getDriver());

    public BasePage() {
        header = new Header(getDriver());
        footer = new Footer(getDriver());
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        try{
            waitUntilJSReady();
            waitForJQueryToLoad();
        }catch (Exception e){
            throw new Error();
        }
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public HeaderWithSignIn getHeaderWithoutSignIn() {
        return headerWithoutSignIn;
    }
}
