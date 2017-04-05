package part;

import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AccountPage;
import page.ContactUsPage;
import page.AuthenticationPage;
import webdriver.WebElementMenager;

public class Header {

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(className = "login")
    private WebElement sigInLink;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement runSearchButton;

    @FindBy(css = "a[title=\"View my shopping cart\"]")
    private WebElement shoppingCartLink;

    @FindBy(className = "cart_block")
    private WebElement cartBlock;

    @FindBy(className = "remove_link")
    private WebElement removeLink;

    @FindBy(css = "a[title=\"T-shirts\"]")
    private WebElement tShortLink;

    @FindBy(css = "a[title=\"Women\"]")
    private WebElement womenLink;

    @FindBy(className = "account")
    private WebElement accountLink;


    public ContactUsPage clickContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignInLink() {
        sigInLink.click();
        return new AuthenticationPage(driver);
    }

    public void setSearchingText(String text) {
        searchInput.sendKeys(text);
    }

    public void clickRunSearchButton() {
        runSearchButton.click();
    }


    public boolean isNotEmptyCard() {
        mouseOverOnCard();
        WebDriverWait wait = Waiter.getWaiter(driver);
        wait.until(ExpectedConditions.visibilityOf(cartBlock));
        return WebElementMenager.isDisplayed(cartBlock);
    }

    public void deleteProductFromCard() {
        mouseOverOnCard();
        removeLink.click();
        WebDriverWait wait = Waiter.getWaiter(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cart_block")));
    }

    public boolean isEmptyCard() {
        mouseOverOnCard();
        return !WebElementMenager.isDisplayed(cartBlock);
    }

    private void mouseOverOnCard() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLink).build().perform();
    }

    public void clickOnTShortLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(womenLink).build().perform();
        tShortLink.click();
    }

    public AccountPage clickAccountLink() {
        accountLink.click();
        return new AccountPage(driver, this);
    }
}
