package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage {
    WebDriver driver ;

    //////////// locators

    private By Activity_Loc = AppiumBy.accessibilityId("Activity");

    public AppPage(WebDriver driver) {
        this.driver = driver;
    }

    public ActivityPage ClickOnActivity()
    {
        ElementsActions.click(driver,Activity_Loc);
        return new ActivityPage(driver);
    }
}
