import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.ContactUsPage;
import page.MainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

@Listeners(MyListener.class)
public class PositiveSendFromContactUsPage extends BaseTest {

    private MainPage mainPage;
    private ContactUsPage contactUsPage;
    private static final String ERROR_MESSAGE = "Success Message is not displayed!";

    @Test
    @TestCaseId("E1")
    @Features("Sent Data Positive")
    @Stories("Story 1")
    @Description("Verify that we can sent data")
    public void positiveSend() {
        mainPage = new MainPage(driver);
        contactUsPage = mainPage.clickContactUsLink();
        contactUsPage.enterDataInAllField();
        contactUsPage.clickSubmit();
        Assert.assertTrue(contactUsPage.isDislayedSuccessMessage(), ERROR_MESSAGE);
    }
}
