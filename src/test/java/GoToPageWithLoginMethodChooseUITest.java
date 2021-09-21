import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoToPageWithLoginMethodChooseUITest extends BaseMethods {

    @Test
    public void testGoToPageWithLoginMethodChooseUITest() {
        System.out.println(this.getClass().getName() + " " + "started!");
        StartPage1 startPage1 = new StartPage1(driver);
        PreLoginPage2 preLoginPage2 = new PreLoginPage2(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage1.submitBegin.isDisplayed();
        startPage1.submitBegin.click();

        softAssert.assertTrue(preLoginPage2.mobikeyImg.isDisplayed(), "Mobikey image is not displayed");
        softAssert.assertTrue(preLoginPage2.loginButton.isDisplayed(), "Login button image is not displayed");
        softAssert.assertTrue(preLoginPage2.hyundaiImg.isDisplayed(), "Hyundai image is not displayed");
        softAssert.assertTrue(preLoginPage2.kiImg.isDisplayed(), "KI image is not displayed");
        softAssert.assertTrue(preLoginPage2.genesisImg.isDisplayed(), "Genesis image is not displayed");

        softAssert.assertEquals(preLoginPage2.loginButtonText.getText(), "Войти как клиент Mobility", "Login button text is incorrect");
        softAssert.assertEquals(preLoginPage2.chooseVendorText.getText(), "или выбрать марку собственного автомобиля", "Choose vendor of your car text is incorrect");

        softAssert.assertAll();
    }

}
