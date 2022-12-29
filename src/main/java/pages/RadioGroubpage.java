package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioGroubpage {

    WebDriver driver;

    private By dinnerRadio_Button = AppiumBy.accessibilityId("Dinner");
    public RadioGroubpage(WebDriver driver) {
        this.driver= driver;
    }

    public void clickRadioButton()
    {
        ElementsActions.click(driver,dinnerRadio_Button);
    }

    public String isChecked()
    {
        return driver.findElement(dinnerRadio_Button).getAttribute("checked");
    }
}
