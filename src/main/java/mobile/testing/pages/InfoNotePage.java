package mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class InfoNotePage extends BasePage {
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmButton;

    public CalculatorPage agreeWithNote() {
        confirmButton.click();
        return new CalculatorPage();
    }
}
