package page;

import helper.RandomData;
import helper.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import part.Header;

public class NewAccountPage {

    private WebDriver driver;
    private Header header;
    private AccountPage accountPage;
//count label in box
    private static final int STATE_COUNT = 54;
    private static final int MONTH_COUNT = 12;
    private static final int YEAR_COUNT = 116;
    private static final int DAY_COUNT = 28;


    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysBirthdaySelector;

    @FindBy(id = "months")
    private WebElement monthsBirthdaySelector;

    @FindBy(id = "years")
    private WebElement yearsBirthdaySelector;

    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckBox;

    @FindBy(id = "optin")
    private WebElement newOfferCheckBox;

    @FindBy(id = "company")
    private WebElement companyForAdressInput;

    @FindBy(id = "address1")
    private WebElement address1LineForAdressInput;

    @FindBy(id = "address2")
    private WebElement address2LineForAdressInput;

    @FindBy(id = "city")
    private WebElement cityForAdressInput;

    @FindBy(id = "id_state")
    private WebElement stateLineForAdressSelector;

    @FindBy(id = "postcode")
    private WebElement postCodeForAdressInput;

    @FindBy(id = "other")
    private WebElement additionalInformationForAdressInput;

    @FindBy(id = "phone")
    private WebElement phoneHomeAdressInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileForAdressInput;

    @FindBy(id = "alias")
    private WebElement aliasForAdressInput;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(className = "info-account")
    private WebElement infoAccount;

    public void setDate() {
        setMailCheckbox();
        customerFirstnameInput.sendKeys(RandomData.getFiratName());
        customerLastnameInput.sendKeys(RandomData.getLastName());
        passwordInput.sendKeys(RandomData.getPassword());
        setDateOfBirthDay();
        setNewsLetterCheckBox();
        setNewsOfferCheckBox();
        companyForAdressInput.sendKeys(RandomData.getCompany());
        address1LineForAdressInput.sendKeys(RandomData.getAress());
        address2LineForAdressInput.sendKeys(RandomData.getAdress2());
        cityForAdressInput.sendKeys(RandomData.getCity());
        setState();
        postCodeForAdressInput.sendKeys(RandomData.getPostalCode());
        additionalInformationForAdressInput.sendKeys(RandomData.getAdditionalInfo());
        phoneHomeAdressInput.sendKeys(RandomData.getHomePhone());
        phoneMobileForAdressInput.sendKeys(RandomData.getMobilePhone());
        aliasForAdressInput.sendKeys(RandomData.getAllias());
    }

    public void clickSubmitButton() {
        submitAccountButton.click();
        accountPage = new AccountPage(driver, header);
    }

    private void setState() {
        Select selectState = new Select(stateLineForAdressSelector);
        selectState.selectByIndex(Randomizer.getRandomSelector(STATE_COUNT));
    }

    private void setNewsLetterCheckBox() {
        if (Randomizer.getRandomBoolean()) {
            newsLetterCheckBox.click();
        }
    }

    private void setNewsOfferCheckBox() {
        if (Randomizer.getRandomBoolean()) {
            newOfferCheckBox.click();
        }
    }

    private void setMailCheckbox() {
        if (Randomizer.getRandomBoolean()) {
            mrRadioButton.click();
        } else {
            mrsRadioButton.click();
        }
    }

    private void setDateOfBirthDay() {
        Select selectYear = new Select(yearsBirthdaySelector);
        Select selectMonth = new Select(monthsBirthdaySelector);
        Select selectDay = new Select(daysBirthdaySelector);
        selectDay.selectByIndex(Randomizer.getRandomSelector(DAY_COUNT));
        selectMonth.selectByIndex(Randomizer.getRandomSelector(MONTH_COUNT));
        selectYear.selectByIndex(Randomizer.getRandomSelector(YEAR_COUNT));
    }

    public boolean isNewAccountPage() {
        return accountPage.isNewAccountPage();
    }
}
