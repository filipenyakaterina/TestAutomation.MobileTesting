package mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormulaSelectorPage extends BasePage {
    @AndroidFindBy(id = "com.codium.bmicalculator:id/new_formula_check_image")
    private MobileElement newFormulaCheckButton;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/standard_formula_check_image")
    private MobileElement standardFormulaCheckButton;

    public BMIResultPage selectNewFormula() {
        newFormulaCheckButton.click();
        return new BMIResultPage();
    }

    public BMIResultPage selectStandardFormula() {
        standardFormulaCheckButton.click();
        return new BMIResultPage();
    }
}
