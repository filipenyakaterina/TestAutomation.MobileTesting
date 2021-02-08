package mobile.testing.model;

public class Instance {
    private double heightInCentimetres;
    private double heightInFeet;
    private double heightInInches;
    private double weightInKilograms;
    private double weightInPounds;
    private double weightInStones;
    private double weightInPoundsOptional;
    private double bmiStandardFormula;
    private double bmiNewFormula;

    public Instance(String heightInCentimetres, String heightInFeet, String heightInInches,
                    String weightInKilograms, String weightInPounds, String weightInStones,
                    String weightInPoundsOptional, String bmiStandardFormula, String bmiNewFormula) {
        this.heightInCentimetres = Double.parseDouble(heightInCentimetres);
        this.heightInFeet = Double.parseDouble(heightInFeet);
        this.heightInInches = Double.parseDouble(heightInInches);
        this.weightInKilograms = Double.parseDouble(weightInKilograms);
        this.weightInPounds = Double.parseDouble(weightInPounds);
        this.weightInStones = Double.parseDouble(weightInStones);
        this.weightInPoundsOptional = Double.parseDouble(weightInPoundsOptional);
        this.bmiStandardFormula = Double.parseDouble(bmiStandardFormula);
        this.bmiNewFormula = Double.parseDouble(bmiNewFormula);
    }

    public double getHeightInCentimetres() {
        return heightInCentimetres;
    }

    public double getHeightInFeet() {
        return heightInFeet;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public double getWeightInStones() {
        return weightInStones;
    }

    public double getWeightInPoundsOptional() {
        return weightInPoundsOptional;
    }

    public double getBmiStandardFormula() {
        return bmiStandardFormula;
    }

    public double getBmiNewFormula() {
        return bmiNewFormula;
    }
}

