
public class TestBloodData {
    public static void main(String[] args) {
        BloodData bloodData1 = new BloodData();
        BloodData bloodData2;

        bloodData2 = new BloodData(BloodType.AB, '-');

        System.out.println("Blood Data 1: " + bloodData1);
        System.out.println("Blood Data 2: " + bloodData2);

        bloodData1.setBloodType(BloodType.B);
        bloodData1.setRhFactor('+');

        System.out.println("Blood Data 1 after changes have been made: " + bloodData1);
        System.out.println("Blood Data 2 after changes have been made"+ bloodData2);
    }
}
