import Actions.MobileActions;
import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class AndroidTests {

    WebDriver driver;

    HomePage homePage;
    Custom_TitlePage custom_titlePage;
    AccessibilityNodeQueryingPage accessibilityNodeQueryingPage;
    RadioGroubpage radioGroubpage;
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\ApiDemos-debug.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "realme 6");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);

        testData = new SHAFT.TestData.JSON("TestData.json");

        homePage = new HomePage(driver);
        radioGroubpage= new RadioGroubpage(driver);
        accessibilityNodeQueryingPage = new AccessibilityNodeQueryingPage(driver);
    }

    @Test
    public void testTyping() {
        // Navigate to APP ,activity , custom title , type "Appium" and check If the text written or not

        homePage.clickOnApp()
                .ClickOnActivity()
                .clickOnCustom_Title()
                .setTextField(testData.getTestData("ExpectedResult"), true)
                .clickOnChangeLeft_BTN();
        assertEquals(testData.getTestData("ExpectedResult"), custom_titlePage.getAppearedtext());
    }

    @Test
    public void testCheckBox() {
        // Navigate to Access'ibility , Accessibility Node Querying , click on any checkbox and validate that the checkbox is checked
        homePage.clickOnAccessibility()
                .clickNodeQuerying()
                .clickCheckButton();
        assertEquals(testData.getTestData("isChecked"), accessibilityNodeQueryingPage.isChecked());

    }

    @Test
    public void testSwiping() {
        // Navigate to Graphics , Vertices , Swipe right on the photo and then swipe left
        homePage.clickOnGraphics()
                .clickOnVertices()
                .SwipingRightAndLeft();
    }

    @Test
    public void testRadioButton() {
        // Navigate to Views , Radio Group , click on any radio button and check If it's selected or not
        homePage.clickOnViews()
                .clickOnVertices()
                .clickRadioButton();
        assertEquals(testData.getTestData("isChecked"),radioGroubpage.isChecked());

    }

}








//       .validateApprearedText("Appium");