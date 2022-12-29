package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    //// locators

    private By App_Loc = new AppiumBy.ByAccessibilityId("App");
    private By Accessibility_Loc = new AppiumBy.ByAccessibilityId("Access'ibility");
    private By Graphics_Loc = new AppiumBy.ByAccessibilityId("Graphics");
    private By Views_Loc = new AppiumBy.ByAccessibilityId("Views");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AppPage clickOnApp()
    {
        ElementsActions.click(driver,App_Loc);
        return new AppPage(driver);
    }

    public GraphicsPage clickOnGraphics()
    {
        ElementsActions.click(driver,Graphics_Loc);
        return new GraphicsPage(driver);
    }

    public AccessibilityPage clickOnAccessibility()
    {
        ElementsActions.click(driver,Accessibility_Loc);
        return new AccessibilityPage(driver);
    }

    public ViewsPage clickOnViews()
    {
        ElementsActions.click(driver,Views_Loc);
        return new ViewsPage(driver);
    }






}
