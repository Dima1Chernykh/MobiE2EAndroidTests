import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class HelpOnRoadTest extends Methods {

    @Test
    public void testHelpOnRoad() {
        System.out.println(this.getClass().getName() + " " + "started!");

        loginToDev();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        RoadHelpPage roadHelpPage = new RoadHelpPage(driver);
        SoftAssert softAssert = new SoftAssert();

        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // help on road button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.9);

        softAssert.assertTrue(roadHelpPage.helpHeader.isDisplayed(), "Help on road page is not present");
        softAssert.assertTrue(roadHelpPage.active.isDisplayed(), "active is not present");
        softAssert.assertTrue(roadHelpPage.whatIHave.isDisplayed(), "whatIHave is not present");
        softAssert.assertTrue(roadHelpPage.forCall.isDisplayed(), "forCall is not present");
        softAssert.assertTrue(roadHelpPage.callButton.isDisplayed(), "callButton is not present");
        softAssert.assertTrue(roadHelpPage.sosText.isDisplayed(), "sosText is not present");
        softAssert.assertTrue(roadHelpPage.sosImg.isDisplayed(), "sosImg is not present");
        roadHelpPage.whatIHave.click();
        softAssert.assertTrue(roadHelpPage.whatIHaveHeader.isDisplayed(), "Modal is not present");

        // swipe bottom
        new TouchAction(driver)
                .press(PointOption.point((int)returnX(carManagementPage.functionalityScreen,0.5), (int)returnY(carManagementPage.functionalityScreen, 0.38)))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point((int)returnX(carManagementPage.functionalityScreen,0.5), (int)returnY(carManagementPage.functionalityScreen, 0.98)))
                .release()
                .perform();

        roadHelpPage.callButton.click();
        softAssert.assertTrue(roadHelpPage.callNumber.isDisplayed(), "Call is not presented");

        softAssert.assertAll();
    }

}
