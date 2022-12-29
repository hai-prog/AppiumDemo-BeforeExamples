package pages;

import Actions.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessibilityNodeQueryingPage {
    WebDriver driver;
    // Locators

    private By checkButton = By.xpath("(//android.widget.CheckBox[@resource-id=\"io.appium.android.apis:id/tasklist_finished\"])[3]");

    public AccessibilityNodeQueryingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckButton()
    {
        ElementsActions.click(driver,checkButton);
    }

    public String isChecked()
    {
       return driver.findElement(checkButton).getAttribute("checked");
    }
}
