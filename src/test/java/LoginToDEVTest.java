import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginToDEVTest extends BaseMethods {

    @Test
    public void testLoginToDEVTest() {
        System.out.println(this.getClass().getName() + " " + "started!");

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        StartPage1 startPage1 = new StartPage1(this.driver);
        PreLoginPage2 preLoginPage2 = new PreLoginPage2(this.driver);
        PhoneNumberPage3 phoneNumberPage3 = new PhoneNumberPage3(this.driver);
        PhoneCallingPage4 phoneCallingPage4 = new PhoneCallingPage4(this.driver);
        CarManagementPage carManagementPage = new CarManagementPage(this.driver);
        SideMenuPage sideMenuPage = new SideMenuPage(this.driver);
        SoftAssert softAssert = new SoftAssert();

        wait.until(ExpectedConditions.elementToBeClickable((startPage1.submitBegin)));
        startPage1.submitBegin.click();
        wait.until(ExpectedConditions.elementToBeClickable((preLoginPage2.loginButton)));
        preLoginPage2.loginButton.click();

        phoneNumberPage3.phoneNumberInput.isDisplayed();
        phoneNumberPage3.phoneNumberInput.sendKeys(phoneNumberPage3.phoneNumber);
        String phoneNumberEntered = phoneNumberPage3.phoneNumberInput.getText();

        phoneNumberPage3.consentCheckbox.click();
        phoneNumberPage3.consentCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable((phoneNumberPage3.continueButton)));
        phoneNumberPage3.continueButton.click();

        phoneCallingPage4.bottomSheet.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable((phoneCallingPage4.devButton)));
        phoneCallingPage4.devButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((phoneCallingPage4.alertOKButton)));
        phoneCallingPage4.alertOKButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((phoneCallingPage4.yesCalledButton)));
        phoneCallingPage4.yesCalledButton.click();

        wait.until(ExpectedConditions.elementToBeClickable((phoneCallingPage4.confirmCodeInput)));
        phoneCallingPage4.confirmCodeInput.sendKeys(phoneCallingPage4.confirmCodeDEV);

        softAssert.assertTrue(carManagementPage.carManagementHeader.isDisplayed(), "Login is not completed");

        // check phone number of user
        carManagementPage.burgerButton.click();
        sideMenuPage.mobikeyImage.isEnabled();
        softAssert.assertEquals(phoneNumberEntered, sideMenuPage.phoneNumberText.getText(), "Phone numbers is not matches");

        softAssert.assertAll();

    }

}
