package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessibilityPage {
    WebDriver driver;

    //  locators
    private By AccessibilityQueryingNode = new AppiumBy.ByAccessibilityId("Accessibility Node Querying");

    public AccessibilityPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccessibilityNodeQueryingPage clickNodeQuerying()
    {
        ElementsActions.click(driver, AccessibilityQueryingNode);
        return new AccessibilityNodeQueryingPage(driver);
    }
}
