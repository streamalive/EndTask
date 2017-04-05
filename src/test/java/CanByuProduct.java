import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.AccountPage;
import page.CatalogPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

@Listeners(MyListener.class)
public class CanByuProduct extends BaseTest {

    private static final String ERROR_MESSAGE = "Buy is not exist, sorry";
    private static final String SEARCHED_PRODUCT = "Blouse";
    private CatalogPage catalogPage;
    private AccountPage accountPage;

    @Test
    @TestCaseId("E7")
    @Features("Full path")
    @Stories("Story 7")
    @Description("Verify that we can buy product")
    public void tShortExistTest() {
        registryNewUser();
        catalogPage = mainPage.searchProduct(SEARCHED_PRODUCT);
        catalogPage.addProductToCard();
        catalogPage.nextNextByu();
        accountPage = catalogPage.getHeader().clickAccountLink();
        accountPage.clicOnOrderLink();
        Assert.assertTrue(accountPage.isExistBuy(), ERROR_MESSAGE);
    }
}
