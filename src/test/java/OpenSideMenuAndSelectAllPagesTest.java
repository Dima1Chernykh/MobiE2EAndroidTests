import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSideMenuAndSelectAllPagesTest extends BaseMethods {

    @Test
    public void testOpenSideMenuAndSelectAllPages() throws InterruptedException {
        System.out.println(this.getClass().getName() + " " + "started!");
        Methods methods = new Methods();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        DocumentsPage documentsPage = new DocumentsPage(driver);
        VINCheckPage vinCheckPage = new VINCheckPage(driver);
        PhoneNumberPage3 phoneNumberPage3 = new PhoneNumberPage3(driver);
        StartPage1 startPage1 = new StartPage1(driver);

        methods.loginToDev();

        carManagementPage.burgerButton.isEnabled();
        carManagementPage.burgerButton.click();

        Assert.assertTrue(sideMenuPage.mobikeyImage.isDisplayed(), "Mobikey image is not displayed");
        Assert.assertTrue(sideMenuPage.phoneNumberText.isDisplayed(), "Phone number is not displayed");
        Assert.assertTrue(sideMenuPage.mobikey.isDisplayed(), "Mobikey is not displayed");
        Assert.assertTrue(sideMenuPage.profile.isDisplayed(), "Profile is not displayed");
        Assert.assertTrue(sideMenuPage.documents.isDisplayed(), "Documents is not displayed");
        Assert.assertTrue(sideMenuPage.VINCheck.isDisplayed(), "VIN check is not displayed");
        Assert.assertTrue(sideMenuPage.logout.isDisplayed(), "Logout is not displayed");

        // check page Mobikey
        sideMenuPage.mobikey.click();
        Assert.assertTrue(carManagementPage.carManagementHeader.isDisplayed(), "Mobikey is not opened");

        // check page Profile
        Thread.sleep(2000);
        carManagementPage.burgerButton.isEnabled();
        carManagementPage.burgerButton.click();
        sideMenuPage.profile.isEnabled();
        sideMenuPage.profile.click();
        Assert.assertTrue(profilePage.profileHeader.isDisplayed(), "Profile is not opened");
        Assert.assertTrue(profilePage.phoneHeader.isDisplayed(), "Phone area header is not present");
        Assert.assertEquals(profilePage.phoneNumber.getText(), ("+7" + phoneNumberPage3.phoneNumber), "Phone number is not present or incorrect");
        Assert.assertTrue(profilePage.deactivationMISOS.isDisplayed(), "Deactivated button is not present");
        profilePage.backArrow.isEnabled();
        profilePage.backArrow.click();

        // check page Documents
        Thread.sleep(2000);
        carManagementPage.burgerButtonAfterBack.click();
        sideMenuPage.documents.isEnabled();
        sideMenuPage.documents.click();
        Assert.assertTrue(documentsPage.documentsHeader.isDisplayed(), "Documents is not opened");
        Assert.assertTrue(documentsPage.mobikeyManual.isDisplayed(), "mobikeyManual is not present");
        Assert.assertTrue(documentsPage.userAgreement.isDisplayed(), "userAgreement is not present");
        Assert.assertTrue(documentsPage.personalData.isDisplayed(), "personalData is not present");
        Assert.assertTrue(documentsPage.privacyPolicy.isDisplayed(), "privacyPolicy is not present");
        documentsPage.backArrow.isEnabled();
        documentsPage.backArrow.click();

        // check page VIN check
        Thread.sleep(2000);
        carManagementPage.burgerButtonAfterBack.click();
        sideMenuPage.VINCheck.isEnabled();
        sideMenuPage.VINCheck.click();
        Assert.assertTrue(vinCheckPage.vinCheckHeader.isDisplayed(), "VIN check is not opened");

        // check Logout
        Thread.sleep(2000);
        vinCheckPage.burgerButton.click();
        sideMenuPage.logout.isEnabled();
        sideMenuPage.logout.click();
        Assert.assertTrue(startPage1.startPageImg.isDisplayed(), "Logout is not worked");
    }

}
