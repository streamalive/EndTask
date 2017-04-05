import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.MainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

@Listeners(MyListener.class)
public class ExistProductInCategory extends BaseTest {

    private CatalogPage catalogPage;
    private static final String ERROR_MESSAGE = "Product is not exist, or it's no T-Short";

    @Test
    @TestCaseId("E6")
    @Features("navigate")
    @Stories("Story 6")
    @Description("Verify that we can navigate")
    public void tShortExistTest() {
        mainPage = new MainPage(driver);
        catalogPage = mainPage.clickOnTShortLink();
        Assert.assertTrue(catalogPage.isTShortExist(), ERROR_MESSAGE);
    }
}
