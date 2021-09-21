import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseMethods {

    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("no-reset", "true");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.hyundai.mobility.mobikey");
        capabilities.setCapability("appActivity", "com.hyundai.mobility.mobikey.MainActivity");
        capabilities.setCapability("systemPort", "8200");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        System.out.println("Test is started...");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Test is completed...");
        driver.quit();
    }
}

// allure generate --clean --output allure-results
// allure serve -h localhost
// to restart appium
// adb uninstall io.appium.uiautomator2.server
// adb uninstall io.appium.uiautomator2.server.test
