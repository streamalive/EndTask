package page;

import helper.RandomData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import part.Header;
import webdriver.WebElementMenager;


public class ContactUsPage {

    private WebDriver driver;
    private Header header;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    private WebElement headingDropDawn;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderReferenceInput;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadInput;

    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageBatton;

    @FindBy(className = "alert-success")
    private WebElement sucsessMassage;

    @FindBy(className = "alert-danger")
    private WebElement failMassage;

    public void enterDataInAllField() {
        enterDateInFieldExceptMessage();
        messageTextArea.sendKeys(RandomData.getMessage());
    }

    public void enterDateInFieldExceptMessage() {
        selectField(RandomData.getDropdawnLabel() );
        emailInput.sendKeys(RandomData.getEmail());
        orderReferenceInput.sendKeys(RandomData.getOrderReference());
        fileUploadInput.sendKeys(getPathForUpload(RandomData.getPathToFile()));
    }


    public void clickSubmit() {
        submitMessageBatton.click();
    }

    public boolean isDislayedSuccessMessage() {
        return WebElementMenager.isDisplayed(sucsessMassage);
    }

    public boolean isDislayedFailMessageAndMessageCorrect() {
        if (!WebElementMenager.isDisplayed(failMassage)) {
            return WebElementMenager.isDisplayed(failMassage);
        }
        WebElement failMessageTextNode = failMassage.findElement(By.cssSelector("ol>li"));
        String failMessageText = failMessageTextNode.getText();
        String failMessage = RandomData.getFailMessage();
        return failMessage == failMessageText;
    }

    private void selectField(String value) {
        Select select = new Select(headingDropDawn);
        select.selectByVisibleText(value);
    }

    private String getPathForUpload(String pathToFile) {
        return new java.io.File(pathToFile).getAbsolutePath();
    }
}
