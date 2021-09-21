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
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OpenStatisticTest extends Methods {

    @Test
    public void testOpenStatistic() {
        System.out.println(this.getClass().getName() + " " + "started!");
        CarManagementPage carManagementPage = new CarManagementPage(driver);
        StatisticPage statisticPage = new StatisticPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginToDev();

        // "+" button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.59);
        // statistic button
        tapElementAt(carManagementPage.functionalityScreen, 0.5, 0.72);

        softAssert.assertTrue(statisticPage.statisticHeader.isDisplayed(), "Statistic page is not present");
        softAssert.assertTrue(statisticPage.backArrowButton.isDisplayed(), "backArrowButton is not present");
        softAssert.assertTrue(statisticPage.days.isDisplayed(), "days is not present");
        softAssert.assertTrue(statisticPage.monday.isDisplayed(), "days in days is not present");
        softAssert.assertTrue(statisticPage.months.isDisplayed(), "months is not present");
        statisticPage.months.click();
        softAssert.assertTrue(statisticPage.jan.isDisplayed(), "months in months is not present");
        softAssert.assertEquals(statisticPage.avgInDays.getText(), "Ср. загрузка в будни" , "avgInDays in months is not present");
        softAssert.assertEquals(statisticPage.avgInHolidays.getText(), "Ср. загрузка в выходные", "avgInHolidays in months is not present");
        softAssert.assertEquals(statisticPage.trips.getText(), "Количество поездок", "trips in months is not present");
        softAssert.assertEquals(statisticPage.onWay.getText(), "Общее время в пути", "onWay in months is not present");
        softAssert.assertEquals(statisticPage.style.getText(), "Стиль вождения", "style in months is not present");
        softAssert.assertEquals(statisticPage.maxSpeed.getText(), "Максимальная скорость", "maxSpeed in months is not present");
        softAssert.assertEquals(statisticPage.avgSpeed.getText(), "Средняя скорость", "avgSpeed in months is not present");

        softAssert.assertAll();

    }

}
