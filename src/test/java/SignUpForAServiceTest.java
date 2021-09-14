import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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

public class SignUpForAServiceTest extends Methods {

    @Test
    public void testSignUpForAServiceTest() throws InterruptedException {
        System.out.println(this.getClass().getName() + " " + "started!");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        loginToDev();
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        ServicePage servicePage = new ServicePage(driver);
        PhoneNumberPage3 phoneNumberPage = new PhoneNumberPage3(driver);
        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // Sign up for a service button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.8);

        Assert.assertTrue(servicePage.serviceHeader.isDisplayed(), "Service page is not present");
        Assert.assertTrue(servicePage.carImg.isDisplayed(), "carImg is not present");
        Assert.assertTrue(servicePage.carModel.isDisplayed(), "carModel is not present");
        Assert.assertTrue(servicePage.carGrz.isDisplayed(), "carGrz is not present");
        Assert.assertTrue(servicePage.chooseCarButton.isDisplayed(), "chooseCarButton is not present");
        servicePage.chooseCarButton.click();
        Assert.assertTrue(servicePage.chooseModel.isDisplayed(), "Choose car page or chooseModel is not present");
        Assert.assertTrue(servicePage.chooseImg.isDisplayed(), "chooseImg is not present");
        Assert.assertTrue(servicePage.chooseGrz.isDisplayed(), "chooseGrz is not present");
        Assert.assertTrue(servicePage.chooseVin.isDisplayed(), "chooseVin is not present");
        servicePage.chooseImg.click();
        Assert.assertTrue(servicePage.vin.isDisplayed(), "vin is not present");
        Assert.assertTrue(servicePage.year.isDisplayed(), "year is not present");
        Assert.assertTrue(servicePage.guarantee.isDisplayed(), "guarantee is not present");
        Assert.assertTrue(servicePage.TOWork.isDisplayed(), "TOWork is not present");
        Assert.assertTrue(servicePage.tiresWork.isDisplayed(), "tiresWork is not present");
        Assert.assertTrue(servicePage.repairWork.isDisplayed(), "repairWork is not present");
        Assert.assertTrue(servicePage.comment.isDisplayed(), "comment is not present");
        Assert.assertTrue(servicePage.selectButton.isDisplayed(), "selectButton is not present");

        servicePage.TOWork.click();
        servicePage.selectButton.click();
        Assert.assertTrue(servicePage.servicesHeader.isDisplayed(), "servicesHeader is not present");
        Assert.assertTrue(servicePage.servicesDescription.isDisplayed(), "servicesHeader is not present");
        servicePage.backArrowServices.click();
        servicePage.TOWork.click();

        servicePage.tiresWork.click();
        servicePage.selectButton.click();
        Assert.assertTrue(servicePage.servicesHeader.isDisplayed(), "servicesHeader is not present");
        Assert.assertTrue(servicePage.servicesDescription.isDisplayed(), "servicesHeader is not present");
        servicePage.backArrowServices.click();
        servicePage.tiresWork.click();

        String repair = servicePage.repairWork.getText();
        servicePage.repairWork.click();
        servicePage.selectButton.click();
        Assert.assertTrue(servicePage.servicesHeader.isDisplayed(), "servicesHeader is not present");
        Assert.assertTrue(servicePage.servicesDescription.isDisplayed(), "servicesHeader is not present");

        // search Автоцентр АНТ in services by scroll
        wait.until(ExpectedConditions.elementToBeClickable(servicePage.firstService));

        boolean isInView = false;

        while (!isInView) {
            try {
                servicePage.servicesList.findElementByXPath("//*[contains(@text, 'Автоцентр АНТ')]");
                isInView = true;
            } catch(NoSuchElementException e) {
                new TouchAction(driver)
                        .press(PointOption.point((int)returnX(servicePage.servicesList,0.5), (int)returnY(servicePage.servicesList, 0.9)))
                        .waitAction(waitOptions(ofMillis(500)))
                        .moveTo(PointOption.point((int)returnX(servicePage.servicesList,0.5), (int)returnY(servicePage.servicesList, 0.3)))
                        .release()
                        .perform();
                Thread.sleep(100);
            }
        }

        WebElement ant = servicePage.servicesList.findElementByXPath("//*[contains(@text, 'Автоцентр АНТ')]");

        ant.click();

        wait.until(ExpectedConditions.elementToBeClickable(servicePage.acceptServiceButton));
        servicePage.acceptServiceButton.click();

        Assert.assertTrue(servicePage.carImgAcceptPage.isDisplayed(), "carImgAcceptPage is not present");
        Assert.assertTrue(servicePage.carAcceptPage.isDisplayed(), "carAcceptPage is not present");
        Assert.assertTrue(servicePage.grzAcceptPage.isDisplayed(), "grzAcceptPage is not present");
        Assert.assertTrue(servicePage.vinAcceptPage.isDisplayed(), "vinAcceptPage is not present");
        Assert.assertTrue(servicePage.serviceAddressAcceptPage.isDisplayed(), "serviceAddressAcceptPage is not present");
        Assert.assertTrue(servicePage.dateAcceptPage.isDisplayed(), "dateAcceptPage is not present");
        Assert.assertTrue(servicePage.acceptButtonAcceptPage.isDisplayed(), "acceptButtonAcceptPage is not present");
        Assert.assertEquals(servicePage.phoneAcceptPage.getText(), phoneNumberPage.decoratePhoneNumber, "Phone numbers do not match");
        Assert.assertEquals(repair, servicePage.repairAcceptPage.getText(), "Repairs do not match");

        servicePage.pencilImgAcceptPage.click();
        servicePage.nameInputAcceptPage.sendKeys(generateRandomHexString(6));
        servicePage.acceptButtonAcceptPage.click();

    }

}
