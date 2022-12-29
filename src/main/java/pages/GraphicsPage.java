package pages;

import Actions.ElementsActions;
import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GraphicsPage {
    WebDriver driver;

    private By ScaleToFit = AppiumBy.accessibilityId("ScaleToFit");
    private By vertices = AppiumBy.accessibilityId("Vertices");

    public GraphicsPage(WebDriver driver) {
        this.driver = driver;
    }


    public VerticesPage clickOnVertices()
    {
        MobileActions.scrollDownToSpecificText("Vertices");
        ElementsActions.click(driver,vertices);
        return new VerticesPage(driver);
    }


    public ScaleToFitPage clickOnScaleToFit()
    {
        ElementsActions.scrollDownToSpecificText(driver,"ScaleToFit");
        ElementsActions.click(driver,ScaleToFit);
        return new ScaleToFitPage(driver);
    }
}
