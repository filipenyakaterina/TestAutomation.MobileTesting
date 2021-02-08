package mobile.testing.service;

import mobile.testing.model.Instance;

public class InstanceCreator {
    public static final String HEIGHT_IN_CENTIMETRES = "testdata.instance.height-in-centimetres";
    public static final String HEIGHT_IN_FEET = "testdata.instance.height-in-feet";
    public static final String HEIGHT_IN_INCHES = "testdata.instance.height-in-inches";
    public static final String WEIGHT_IN_KILOGRAMS = "testdata.instance.weight-in-kilograms";
    public static final String WEIGHT_IN_POUNDS = "testdata.instance.weight-in-pounds";
    public static final String WEIGHT_IN_STONES = "testdata.instance.weight-in-stones";
    public static final String WEIGHT_IN_POUNDS_OPTIONAL = "testdata.instance.weight-in-pounds-optional";
    public static final String BMI_STANDARD_FORMULA = "testdata.instance.bmi-standard-formula";
    public static final String BMI_NEW_FORMULA = "testdata.instance.bmi-new-formula";

    public static Instance getInstanceFromProperty() {
        return new Instance(TestDataReader.getTestData(HEIGHT_IN_CENTIMETRES),
                TestDataReader.getTestData(HEIGHT_IN_FEET), TestDataReader.getTestData(HEIGHT_IN_INCHES),
                TestDataReader.getTestData(WEIGHT_IN_KILOGRAMS), TestDataReader.getTestData(WEIGHT_IN_POUNDS),
                TestDataReader.getTestData(WEIGHT_IN_STONES), TestDataReader.getTestData(WEIGHT_IN_POUNDS_OPTIONAL),
                TestDataReader.getTestData(BMI_STANDARD_FORMULA), TestDataReader.getTestData(BMI_NEW_FORMULA));
    }
}
