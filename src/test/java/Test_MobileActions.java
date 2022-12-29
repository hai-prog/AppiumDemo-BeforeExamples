import Actions.MobileActions;
import com.beust.ah.A;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Test_MobileActions {
    WebDriver driver;
    MobileActions mobileActions;

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
        mobileActions = new MobileActions(driver);
    }

    @Test
    public void testClickAction() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(new AppiumBy.ByAccessibilityId("Access'ibility")).click();
        assertEquals(driver.findElement(new AppiumBy.ByAccessibilityId("Accessibility Node Provider")).getText(), "Accessibility Node Provider");
    }

    @Test(dependsOnMethods = "testClickAction")
    public void testTyping() {
        // Navigate to APP ,activity , custom title , type "Appium" and check If the text written or not

        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom Title")).click();

        WebElement textField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Left is best\"]"));
        textField.clear();
        textField.sendKeys("Appium");
        driver.findElement(AppiumBy.accessibilityId("Change Left")).click();
        assertEquals(driver.findElement(By.id("io.appium.android.apis:id/left_text")).getText(),"Appium");
    }

    @Test
    public void testCheckBox() {
        // Navigate to Access'ibility , Accessibility Node Querying , click on any checkbox and validate that the checkbox is checked
        driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
        driver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying")).click();

        WebElement checkList =driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"io.appium.android.apis:id/tasklist_finished\"])[3]"));
        checkList.click();
        assertEquals(checkList.getAttribute("checked"),"true");

    }

    @Test
    public void testScrolling() {
        // Navigate to Graphics , scaleToFit and click on it and check If it's scrolled and clicked or not

        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
        MobileActions.scrollDownToSpecificText("ScaleToFit");
        driver.findElement(AppiumBy.accessibilityId("ScaleToFit")).click();

    }

    @Test
    public void testSwiping() {
        // Navigate to Graphics , Vertices , Swipe right on the photo and then swipe left
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
        MobileActions.scrollDownToSpecificText("Vertices");
        driver.findElement(AppiumBy.accessibilityId("Vertices")).click();
        MobileActions.swipeRightOnElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]"),driver);
        MobileActions.swipeLeftOnElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]"),driver);



    }

    @Test
    public void testRadioButton() {
        // Navigate to Views , Radio Group , click on any radio button and check If it's selected or not
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        MobileActions.scrollDownToSpecificText("Radio Group");
        driver.findElement(AppiumBy.accessibilityId("Radio Group")).click();
        driver.findElement(AppiumBy.accessibilityId("Dinner")).click();
        assertEquals(driver.findElement(AppiumBy.accessibilityId("Dinner")).getAttribute("checked"),"true");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
