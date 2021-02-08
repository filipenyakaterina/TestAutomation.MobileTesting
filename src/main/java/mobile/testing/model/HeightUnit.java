package mobile.testing.model;

public enum HeightUnit {
    CENTIMETRES(1), FEET_AND_INCHES(2);

    private int unitNumber;

    HeightUnit(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
