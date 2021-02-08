package mobile.testing.model;

public enum WeightUnit {
    KILOGRAMS(1), POUNDS(2), STONES(3);

    private int unitNumber;

    WeightUnit(int unitNumber) {
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
