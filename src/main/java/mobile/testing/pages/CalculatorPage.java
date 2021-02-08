package mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobile.testing.model.HeightUnit;
import mobile.testing.model.WeightUnit;
import mobile.testing.pageElements.Spinner;
import mobile.testing.utils.TestLogger;
import org.openqa.selenium.By;

import java.util.List;

public class CalculatorPage extends BasePage {
    @AndroidFindBy(id = "com.codium.bmicalculator:id/height_input_1")
    private MobileElement heightMainPartEdit;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/height_unit_input")
    private MobileElement heightUnitSpinner;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/weight_input_1")
    private MobileElement weightMainPartEdit;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/weight_unit_input")
    private MobileElement weightUnitSpinner;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/calculate_button")
    private MobileElement calculateButton;

    private By optionalPartHeightSelector = By.id("com.codium.bmicalculator:id/height_input_2");
    private By optionalPartWeightSelector = By.id("com.codium.bmicalculator:id/weight_input_2");

    private void enterMainValue(MobileElement mainEdit, double mainValue) {
        String editName = mainEdit.getText();
        mainEdit.sendKeys(String.valueOf(mainValue));
        TestLogger.writeInfoMessage("Value " + mainValue + " was entered to the " + editName + " edit.");
    }

    private void enterOptionValue(By optionalSelector, double optionalValue) {
        List<MobileElement> elementsList = driver.findElements(optionalSelector);
        if (!elementsList.isEmpty()) {
            MobileElement edit = elementsList.get(0);
            String editName = edit.getText();
            edit.sendKeys(String.valueOf(optionalValue));
            TestLogger.writeInfoMessage("Value " + optionalValue + " was entered to the " + editName + " edit.");
        }
    }

    public CalculatorPage enterMainPartHeight(double mainPartHeight) {
        enterMainValue(heightMainPartEdit, mainPartHeight);
        return this;
    }

    public CalculatorPage enterOptionalPartHeight(double optionalPartHeight) {
        enterOptionValue(optionalPartHeightSelector, optionalPartHeight);
        return this;
    }

    public CalculatorPage enterMainPartWeight(double mainPartWeight) {
        enterMainValue(weightMainPartEdit, mainPartWeight);
        return this;
    }

    public CalculatorPage enterOptionalPartWeight(double optionalPartWeight) {
        enterOptionValue(optionalPartWeightSelector, optionalPartWeight);
        return this;
    }

    public CalculatorPage selectHeightUnit(HeightUnit heightUnit) {
        new Spinner(heightUnitSpinner, driver).selectItem(heightUnit.getUnitNumber());
        TestLogger.writeInfoMessage("Height unit {} was selected.", heightUnit);
        return new CalculatorPage();
    }

    public CalculatorPage selectWeightUnit(WeightUnit weightUnit) {
        new Spinner(weightUnitSpinner, driver).selectItem(weightUnit.getUnitNumber());
        TestLogger.writeInfoMessage("Weight unit {} was selected.", weightUnit);
        return new CalculatorPage();
    }

    public BMIResultPage calculate() {
        calculateButton.click();
        TestLogger.writeInfoMessage("Calculate button was pressed.");
        return new BMIResultPage();
    }
}
