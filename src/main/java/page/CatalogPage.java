package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import part.Header;
import webdriver.WebElementMenager;

public class CatalogPage {

    private static final String CATEGORY_NAME = "T-shirts ";

    private WebDriver driver;

    private Header header;

    public CatalogPage(WebDriver driver, Header header) {
        this.driver = driver;
        this.header = header;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pagination")
    private WebElement paginationOfProduct;

    @FindBy(className = "product-container")
    private WebElement product;

    @FindBy(className = "ajax_add_to_cart_button")
    private WebElement addToCardButton;

    @FindBy(className = "cross")
    private WebElement cross;

    @FindBy(className = "cat-name")
    private WebElement categoryName;

    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = ".//*[@id='center_column']/p[2]/a[1]/span")
    private WebElement proceedToCheckoutButtonOnForm1;

    @FindBy(xpath = ".//*[@id='center_column']/form/p/button")
    private WebElement proceedToCheckoutButtonOnForm2;

    @FindBy(xpath = ".//*[@id='form']/p/button")
    private WebElement proceedToCheckoutButtonOnForm3;

    @FindBy(xpath = ".//*[@id='cart_navigation']/button")
    private WebElement confirmOrder;

    @FindBy(id = "cgv")
    private WebElement iAgreeCheckbox;

    @FindBy(className = "cheque")
    private WebElement payCheck;

    public Header getHeader() {
        return header;
    }

    public boolean isProductExist() {
        return WebElementMenager.isDisplayed(paginationOfProduct);
    }

    private boolean isTShortProduct() {
        boolean paginationIsDisplayed = WebElementMenager.isDisplayed(paginationOfProduct);
        boolean categoryNameIscorrect = CATEGORY_NAME.equalsIgnoreCase(categoryName.getText());
        return  paginationIsDisplayed && categoryNameIscorrect;
    }

    public boolean isTShortExist() {
        return isTShortProduct() && isProductExist();
    }

    public void addProductToCard() {
        product.click();
        addToCardButton.click();
    }

    public void closeAdditionalWindow() {
        cross.click();
    }

    public void nextNextByu() {
        proceedToCheckoutButton.click();
        proceedToCheckoutButtonOnForm1.click();
        proceedToCheckoutButtonOnForm2.click();
        iAgreeCheckbox.click();
        proceedToCheckoutButtonOnForm3.click();
        payCheck.click();
        confirmOrder.click();
    }

}
