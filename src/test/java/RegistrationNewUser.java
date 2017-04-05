import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

@Listeners(MyListener.class)
public class RegistrationNewUser extends BaseTest {

    private static final String ERROR_MESSAGE = "Can't Create account";

    @Test
    @TestCaseId("E3")
    @Features("Can registry")
    @Stories("Story 3")
    @Description("Verify that we can Registry")
    public void registrationTest() {
        registryNewUser();
        Assert.assertTrue(newAccountPage.isNewAccountPage(), ERROR_MESSAGE);
    }
}
