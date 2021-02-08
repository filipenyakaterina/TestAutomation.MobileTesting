package mobile.testing.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BMIResultPage extends BasePage {
    @AndroidFindBy(id = "com.codium.bmicalculator:id/result_bmi_text")
    private MobileElement bmiResultText;

    @AndroidFindBy(id = "com.codium.bmicalculator:id/formula_button")
    private MobileElement bmiFormulaButton;

    public Double getBMIValue() {
        return Double.valueOf(bmiResultText.getText());
    }

    public FormulaSelectorPage openFormulaSelector() {
        bmiFormulaButton.click();
        return new FormulaSelectorPage();
    }
}
