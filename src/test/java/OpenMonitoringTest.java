import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OpenMonitoringTest extends Methods {

    @Test
    public void testOpenMonitoring() {
        System.out.println(this.getClass().getName() + " " + "started!");
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        MonitoringPage monitoringPage = new MonitoringPage(driver);

        loginToDev();

        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // drivers button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.63);

        Assert.assertTrue(monitoringPage.monitoringHeader.isDisplayed(), "Monitoring page is not present");
        Assert.assertTrue(monitoringPage.backArrowButton.isDisplayed(), "backArrowButton is not present");
        Assert.assertTrue(monitoringPage.reloadButton.isDisplayed(), "reloadButton is not present");
        Assert.assertTrue(monitoringPage.currentDate.isDisplayed(), "currentDate is not present");
        Assert.assertTrue(monitoringPage.currentPlaceButton.isDisplayed(), "currentPlaceButton is not present");

    }

}
