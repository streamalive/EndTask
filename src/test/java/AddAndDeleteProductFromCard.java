import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CatalogPage;
import page.MainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

@Listeners(MyListener.class)
public class AddAndDeleteProductFromCard extends BaseTest {

    private static final String ERROR_MESSAGE_NOT_ADD_TO_CARD = "Product is not exist in card";
    private static final String ERROR_MESSAGE_NOT_DELETE_FROM_CARD = "Product is not delete from card";
    private static final String SEARCHED_PRODUCT = "Blouse";
    private CatalogPage catalogPage;

    @Test
    @TestCaseId("E5")
    @Features("Add and delete from card")
    @Stories("Story 5")
    @Description("Verify that we can add product in card")
    public void cardTest() {
        mainPage = new MainPage(driver);
        catalogPage = mainPage.searchProduct(SEARCHED_PRODUCT);
        catalogPage.addProductToCard();
        catalogPage.closeAdditionalWindow();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.getHeader().isNotEmptyCard(), ERROR_MESSAGE_NOT_ADD_TO_CARD);
        mainPage.getHeader().deleteProductFromCard();
        softAssert.assertTrue(mainPage.getHeader().isEmptyCard(), ERROR_MESSAGE_NOT_DELETE_FROM_CARD);
        softAssert.assertAll();
    }
}
