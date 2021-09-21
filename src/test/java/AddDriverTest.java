import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddDriverTest extends Methods {

    @Test
    public void testAddDriver() throws InterruptedException {
        System.out.println(this.getClass().getName() + " " + "started!");
        loginToDev();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        AddDriverPage addDriverPage = new AddDriverPage(driver);
        SoftAssert softAssert = new SoftAssert();

        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // drivers button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.54);
        // add driver button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.7);

        softAssert.assertTrue(addDriverPage.descriptionText.isDisplayed(), "Add driver page is not present");
        softAssert.assertTrue(addDriverPage.phoneHeaderText.isDisplayed(), "Input header is not present");
        softAssert.assertEquals(addDriverPage.phoneInput.getText(), "+7 999 999 99 99", "Phone input placeholder is not presented");
        softAssert.assertTrue(addDriverPage.addButton.isDisplayed(), "Add button is not present");
        addDriverPage.addFromContactsButton.click();
        softAssert.assertTrue(addDriverPage.searchContactsInput.isDisplayed(), "Contacts page is not present");
        addDriverPage.closeButton.click();
        softAssert.assertTrue(carManagementPage.functionalityScreen.isDisplayed(), "Add driver page is not closed");
        Thread.sleep(500);
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.7);
        addDriverPage.phoneInput.sendKeys("9008008888");
        String phoneText = addDriverPage.phoneInput.getText();
        addDriverPage.addButton.click();
        softAssert.assertTrue(addDriverPage.addDriverHeader.isDisplayed());
        softAssert.assertEquals(phoneText.replaceAll("\\s",""), (addDriverPage.addDriverNumber.getText()));
        addDriverPage.addDriverClose.click();
        softAssert.assertTrue(carManagementPage.functionalityScreen.isDisplayed(), "Add driver page is not closed");

        softAssert.assertAll();
    }

}
