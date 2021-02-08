package mobile.testing.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Spinner {
    private MobileElement rootElement;
    private AppiumDriver<MobileElement> driver;

    public Spinner(MobileElement rootElement, AppiumDriver<MobileElement> driver) {
        this.rootElement = rootElement;
        this.driver = driver;
    }

    public void selectItem(int itemNumber) {
        rootElement.click();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(rootElement.getCenter().x,
                rootElement.getCenter().y + rootElement.getRect().height * itemNumber)).perform();
    }
}
