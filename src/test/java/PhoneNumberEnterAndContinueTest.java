import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PhoneNumberEnterAndContinueTest extends BaseMethods {

    @Test
    public void testPhoneNumberEnterAndContinue() {
        System.out.println(this.getClass().getName() + " " + "started!");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        StartPage1 startPage1 = new StartPage1(driver);
        PreLoginPage2 preLoginPage2 = new PreLoginPage2(driver);
        PhoneNumberPage3 phoneNumberPage3 = new PhoneNumberPage3(driver);
        PhoneCallingPage4 phoneCallingPage4 = new PhoneCallingPage4(driver);
        SoftAssert softAssert = new SoftAssert();

        wait.until(ExpectedConditions.elementToBeClickable((startPage1.submitBegin)));
        startPage1.submitBegin.click();
        wait.until(ExpectedConditions.elementToBeClickable((preLoginPage2.loginButton)));
        preLoginPage2.loginButton.click();

        phoneNumberPage3.phoneNumberInput.isDisplayed();
        phoneNumberPage3.phoneNumberInput.sendKeys("9");
        String phoneStartedText = phoneNumberPage3.phoneNumberInput.getText();
        softAssert.assertEquals(phoneStartedText, "+7 9", "Auto-substitution of '+7' is not worked");
        phoneNumberPage3.phoneNumberInput.clear();

        String defaultPhoneNumber = phoneNumberPage3.phoneNumberInput.getText();
        softAssert.assertEquals(defaultPhoneNumber, "+7 999 999 99 99", "Placeholder of number input is not presented");

        phoneNumberPage3.phoneNumberInput.sendKeys(phoneNumberPage3.phoneNumber);

        phoneNumberPage3.consentCheckbox.click();
        phoneNumberPage3.consentCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable((phoneNumberPage3.continueButton)));
        phoneNumberPage3.continueButton.click();

        softAssert.assertTrue(phoneCallingPage4.phoneCallingHeader.isDisplayed(), "Transition to next page failed");
        softAssert.assertTrue(phoneCallingPage4.bottomSheet.isDisplayed(), "Modal page with the choice of environment did not appear");

        softAssert.assertAll();
    }

}
