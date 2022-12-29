package pages;

import Actions.ElementsActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Custom_TitlePage {

    WebDriver driver;

    /// locators

    private By textField = By.xpath("//android.widget.EditText[@content-desc=\"Left is best\"]");
    private By changeLeft_BTN = AppiumBy.accessibilityId("Change Left");
    private By AppearedText =  By.id("io.appium.android.apis:id/left_text");

    public Custom_TitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public Custom_TitlePage setTextField(String txt, Boolean clearBeforeTyping)
    {
        ElementsActions.setText(driver,textField,txt,clearBeforeTyping);
        return  this;
    }

    public void clickOnChangeLeft_BTN()
    {
        ElementsActions.click(driver,changeLeft_BTN);
    }

    public String getAppearedtext(){
     return ElementsActions.getText(driver,AppearedText);
    }
}




