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
public class SearchProduct extends BaseTest {

    private static final String ERROR_MESSAGE = "Product is not exist";
    private static final String SEARCHED_PRODUCT = "Blouse";
    private CatalogPage catalogPage;

    @Test
    @TestCaseId("E4")
    @Features("Check product")
    @Stories("Story 4")
    @Description("Verify that we find blouse")
    public void searchingTest() {
        mainPage = new MainPage(driver);
        catalogPage = mainPage.searchProduct(SEARCHED_PRODUCT);
        Assert.assertTrue(catalogPage.isProductExist(), ERROR_MESSAGE);
    }
}
