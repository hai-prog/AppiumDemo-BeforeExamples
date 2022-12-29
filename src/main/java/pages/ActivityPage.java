package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage {
    WebDriver driver;

    private By Custom_title_Loc = AppiumBy.accessibilityId("Custom Title");

    public ActivityPage(WebDriver driver) {
        this.driver = driver;
    }

    public Custom_TitlePage clickOnCustom_Title()
    {
        ElementsActions.click(driver,Custom_title_Loc);
        return new Custom_TitlePage(driver);
    }
}
