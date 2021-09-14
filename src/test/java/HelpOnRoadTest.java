import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class HelpOnRoadTest extends Methods {

    @Test
    public void testHelpOnRoad() {
        System.out.println(this.getClass().getName() + " " + "started!");

        loginToDev();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        RoadHelpPage roadHelpPage = new RoadHelpPage(driver);
        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // help on road button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.9);

        Assert.assertTrue(roadHelpPage.helpHeader.isDisplayed(), "Help on road page is not present");
        Assert.assertTrue(roadHelpPage.active.isDisplayed(), "active is not present");
        Assert.assertTrue(roadHelpPage.whatIHave.isDisplayed(), "whatIHave is not present");
        Assert.assertTrue(roadHelpPage.forCall.isDisplayed(), "forCall is not present");
        Assert.assertTrue(roadHelpPage.callButton.isDisplayed(), "callButton is not present");
        Assert.assertTrue(roadHelpPage.sosText.isDisplayed(), "sosText is not present");
        Assert.assertTrue(roadHelpPage.sosImg.isDisplayed(), "sosImg is not present");
        roadHelpPage.whatIHave.click();
        Assert.assertTrue(roadHelpPage.whatIHaveHeader.isDisplayed(), "Modal is not present");

        // swipe bottom
        new TouchAction(driver)
                .press(PointOption.point((int)returnX(carManagementPage.functionalityScreen,0.5), (int)returnY(carManagementPage.functionalityScreen, 0.38)))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point((int)returnX(carManagementPage.functionalityScreen,0.5), (int)returnY(carManagementPage.functionalityScreen, 0.98)))
                .release()
                .perform();

        roadHelpPage.callButton.click();
        Assert.assertTrue(roadHelpPage.callNumber.isDisplayed(), "Call is not presented");

    }

}
