
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class AndroidTests {

    WebDriver driver;
    SHAFT.TestData.JSON testData;

    ////////////////////////Pages
    HomePage homePage;
    Custom_TitlePage custom_titlePage;
    AccessibilityNodeQueryingPage accessibilityNodeQueryingPage;
    RadioGroubpage radioGroubpage;



    @Test(description = "Navigate to APP ,activity , custom title , " +
            "type \"Appium\" and check If the text written or not")
    public void testTyping() {
        homePage.clickOnApp()
                .ClickOnActivity()
                .clickOnCustom_Title()
                .setTextField(testData.getTestData("ExpectedResult"), true)
                .clickOnChangeLeft_BTN();

        assertEquals(testData.getTestData("ExpectedResult"), custom_titlePage.getAppearedtext());
    }

    @Test(description = "Navigate to Access'ibility , Accessibility Node Querying , click on any checkbox and validate that the checkbox is checked")
    public void testCheckBox() {

        homePage.clickOnAccessibility()
                .clickNodeQuerying()
                .clickCheckButton();

        assertEquals(testData.getTestData("isChecked"), accessibilityNodeQueryingPage.isChecked());

    }

    @Test(description = "Navigate to Graphics , Vertices , Swipe right on the photo and then swipe left")
    public void testSwiping() {
        homePage.clickOnGraphics()
                .clickOnVertices()
                .SwipingRightAndLeft();
    }

    @Test(description = "Navigate to Views , Radio Group , click on any radio button and check If it's selected or not")
    public void testRadioButton() {
        homePage.clickOnViews()
                .clickOnradioGroub()
                .clickRadioButton();

        assertEquals(testData.getTestData("isChecked"),radioGroubpage.isChecked());

    }

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
        custom_titlePage = new Custom_TitlePage(driver);
        radioGroubpage= new RadioGroubpage(driver);
        accessibilityNodeQueryingPage = new AccessibilityNodeQueryingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}








