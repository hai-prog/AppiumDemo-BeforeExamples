package pages;

import Actions.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerticesPage {

    WebDriver driver;
    // locators
    private By image_Loc = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");


    public VerticesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SwipingRightAndLeft()
    {
        ElementsActions.swipeLeftOnElement(image_Loc,driver);
        ElementsActions.swipeRightOnElement(image_Loc,driver);
    }
}
