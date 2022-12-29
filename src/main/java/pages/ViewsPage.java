package pages;

import Actions.ElementsActions;
import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewsPage {

    WebDriver driver;
    // locators
   private By radioGroub  = AppiumBy.accessibilityId("Radio Group");

    public ViewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public RadioGroubpage clickOnradioGroub()
    {
        ElementsActions.scrollDownToSpecificText(driver,"Radio Group");
        ElementsActions.click(driver,radioGroub);
        return new RadioGroubpage(driver);
    }
}
