package mobile.testing;

import mobile.testing.model.HeightUnit;
import mobile.testing.model.Instance;
import mobile.testing.model.WeightUnit;
import mobile.testing.pages.InfoNotePage;
import mobile.testing.service.InstanceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewFormulaCalculatorTest extends BaseTest {
    @Test(description = "Check BMI calculated with new formula for height in centimetres and weight in kilograms")
    public void checkBMIForCentimetresAndKilograms() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        double bmi = new InfoNotePage().agreeWithNote().selectHeightUnit(HeightUnit.CENTIMETRES).
                enterMainPartHeight(testInstance.getHeightInCentimetres()).
                enterMainPartWeight(testInstance.getWeightInKilograms()).
                calculate().openFormulaSelector().selectNewFormula().getBMIValue();
        Assert.assertEquals(bmi, testInstance.getBmiNewFormula());
    }

    @Test(description = "Check BMI calculated with new formula for height in feet and inches and weight in pounds")
    public void checkBMIForFeetInchesAndPounds() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        double bmi = new InfoNotePage().agreeWithNote().selectHeightUnit(HeightUnit.FEET_AND_INCHES).
                enterMainPartHeight(testInstance.getHeightInFeet()).enterOptionalPartHeight(testInstance.getHeightInInches()).
                enterMainPartWeight(testInstance.getWeightInPounds()).
                calculate().openFormulaSelector().selectNewFormula().getBMIValue();
        Assert.assertEquals(bmi, testInstance.getBmiNewFormula());
    }

    @Test(description = "Check BMI calculated with new formula for height in feet and inches and weight in stones and pounds")
    public void checkBMIForFeetInchesAndStonesPounds() {
        Instance testInstance = InstanceCreator.getInstanceFromProperty();
        double bmi = new InfoNotePage().agreeWithNote().selectWeightUnit(WeightUnit.STONES).
                enterMainPartHeight(testInstance.getHeightInFeet()).enterOptionalPartHeight(testInstance.getHeightInInches()).
                enterMainPartWeight(testInstance.getWeightInStones()).enterOptionalPartWeight(testInstance.getWeightInPoundsOptional()).
                calculate().openFormulaSelector().selectNewFormula().getBMIValue();
        Assert.assertEquals(bmi, testInstance.getBmiNewFormula());
    }
}
