import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class ClickBagDoorEngineButtonsTest extends Methods {

    @Test
    public void testClickBagDoorEngineButtons() throws InterruptedException {
        System.out.println(this.getClass().getName() + " " + "started!");
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginToDev();

        // check bag
        carManagementPage.loggerCarManagement.click();
        carManagementPage.clearLogCarManagement.click();
        driver.navigate().back();
        tapElementAt(carManagementPage.functionalityScreen,0.5, 0.3);
        carManagementPage.loggerCarManagement.click();
        softAssert.assertTrue(carManagementPage.openBag.isDisplayed(), "Response for bag is not detected");
        // check left door
        Thread.sleep(10000);
        carManagementPage.clearLogCarManagement.click();
        driver.navigate().back();
        tapElementAt(carManagementPage.functionalityScreen,0.2, 0.59);
        carManagementPage.loggerCarManagement.click();
        softAssert.assertTrue(carManagementPage.door.isDisplayed(), "Response for left door is not detected");
        // check right door
        Thread.sleep(10000);
        carManagementPage.clearLogCarManagement.click();
        driver.navigate().back();
        tapElementAt(carManagementPage.functionalityScreen,0.8, 0.59);
        carManagementPage.loggerCarManagement.click();
        softAssert.assertTrue(carManagementPage.door.isDisplayed(), "Response for right door is not detected");
        // start engine
        Thread.sleep(10000);
        carManagementPage.clearLogCarManagement.click();
        driver.navigate().back();
        new TouchAction(driver).press(point((int)returnX(carManagementPage.functionalityScreen,0.5), (int)returnY(carManagementPage.functionalityScreen, 0.77)))
                .waitAction(waitOptions(Duration.ofMillis(5000))).release().perform();
        carManagementPage.loggerCarManagement.click();
        softAssert.assertTrue(carManagementPage.startEng.isDisplayed(), "Response for engine is not detected");

        softAssert.assertAll();
    }

}
