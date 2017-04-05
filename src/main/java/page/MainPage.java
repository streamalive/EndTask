package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import part.Header;

public class MainPage {

    private WebDriver driver;
    private Header header;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return header;
    }

    public ContactUsPage clickContactUsLink() {
        return header.clickContactUsLink();
    }

    public AuthenticationPage clickSignInLink() {
        return header.clickSignInLink();
    }


    public CatalogPage searchProduct(String searchCriteria) {
        header.setSearchingText(searchCriteria);
        header.clickRunSearchButton();
        return new CatalogPage(driver, header);
    }

    public CatalogPage clickOnTShortLink() {
        header.clickOnTShortLink();
        return new CatalogPage(driver, header);
    }

}
