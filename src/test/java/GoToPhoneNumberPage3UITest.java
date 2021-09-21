import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoToPhoneNumberPage3UITest extends BaseMethods {

    @Test
    public void testGoToPhoneNumberPageUI() {
        System.out.println(this.getClass().getName() + " " + "started!");
        StartPage1 startPage1 = new StartPage1(driver);
        PreLoginPage2 preLoginPage2 = new PreLoginPage2(driver);
        PhoneNumberPage3 phoneNumberPage3 = new PhoneNumberPage3(driver);
        SoftAssert softAssert = new SoftAssert();

        startPage1.submitBegin.isDisplayed();
        startPage1.submitBegin.click();
        preLoginPage2.loginButton.isDisplayed();
        preLoginPage2.loginButton.click();

        softAssert.assertTrue(phoneNumberPage3.phoneNumberInput.isDisplayed(), "Phone number is not displayed");
        softAssert.assertTrue(phoneNumberPage3.consentCheckbox.isDisplayed(), "Checkbox is not displayed");
        softAssert.assertTrue(phoneNumberPage3.continueButton.isDisplayed(), "Button Continue is not displayed");

        softAssert.assertEquals(phoneNumberPage3.phoneNumberHeader.getText(), "Номер вашего телефона", "Header of page is incorrect");
        softAssert.assertEquals(phoneNumberPage3.phoneNumberInput.getText(), "+7 999 999 99 99", "Placeholder of input is incorrect");
        softAssert.assertEquals(phoneNumberPage3.consentText.getText(), "Продолжая, я даю согласие ООО «Хендэ Мотор СНГ» на обработку своих Персональных данных и принимаю условия Пользовательского соглашения", "Consent text is incorrect");
        softAssert.assertEquals(phoneNumberPage3.continueButtonText.getText(), "Продолжить", "Continue button text is incorrect");

        softAssert.assertAll();
    }

}
