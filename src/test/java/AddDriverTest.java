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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddDriverTest extends Methods {

    @Test
    public void testAddDriver() {
        System.out.println(this.getClass().getName() + " " + "started!");
        loginToDev();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        AddDriverPage addDriverPage = new AddDriverPage(driver);
        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // drivers button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.54);
        // add driver button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.7);

        Assert.assertTrue(addDriverPage.descriptionText.isDisplayed(), "Add driver page is not present");
        Assert.assertTrue(addDriverPage.phoneHeaderText.isDisplayed(), "Input header is not present");
        Assert.assertEquals(addDriverPage.phoneInput.getText(), "+7 999 999 99 99");
        Assert.assertTrue(addDriverPage.addButton.isDisplayed(), "Add button is not present");
        addDriverPage.addFromContactsButton.click();
        Assert.assertTrue(addDriverPage.searchContactsInput.isDisplayed(), "Contacts page is not present");
        addDriverPage.closeButton.click();
        Assert.assertTrue(carManagementPage.functionalityScreen.isDisplayed(), "Add driver page is not closed");

        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.7);
        addDriverPage.phoneInput.sendKeys("9008008888");
        String phoneText = addDriverPage.phoneInput.getText();
        addDriverPage.addButton.click();
        Assert.assertTrue(addDriverPage.addDriverHeader.isDisplayed());
        Assert.assertEquals(phoneText.replaceAll("\\s",""), (addDriverPage.addDriverNumber.getText()));
        addDriverPage.addDriverClose.click();
        Assert.assertTrue(carManagementPage.functionalityScreen.isDisplayed(), "Add driver page is not closed");
    }

}
