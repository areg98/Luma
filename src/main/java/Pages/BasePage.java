package Pages;

import static utils.CustomWebDriver.getDriver;

public class BasePage {

    private Header header;
    private Footer footer;
    private HeaderWithSignIn headerWithoutSignIn = new HeaderWithSignIn(getDriver());

    public BasePage(){
        header =new Header(getDriver());
        footer =new Footer(getDriver());
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
