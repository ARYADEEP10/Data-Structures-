// BloodData.java
enum BloodType {
    O, A, B, AB
}

class BloodData {
    private BloodType bloodType;
    private char RHFactor;

    public BloodData() {
        this.bloodType = BloodType.O;
        this.RHFactor = '+';
    }

    public BloodData(BloodType bloodType, char RHFactor) {

        this.RHFactor = RHFactor;
        this.bloodType = bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public char getRhFactor() {
        return RHFactor;
    }

    public void setRhFactor(char rhFactor) {
        this.RHFactor = RHFactor;
    }

    @Override
    public String toString() {
        return "Blood Type: " + bloodType + ", Rh Factor: " + RHFactor;
    }
}
