
class Patient {
    private int age;
    private int id;
    private BloodData bloodData;

    public Patient() {
        this.id = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    public Patient(int id, int age, BloodData bloodData) {
        this.id = id;
        this.age = age;
        this.bloodData = bloodData;
    }

    public int getId() {
        return id;
    }
// using the set and get methods to retrieve the ID and age
    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//using get and set methods to get BloodData
    public BloodData getBloodData() {
        return bloodData;
    }

    public void setBloodData(BloodData bloodData) {
        this.bloodData = bloodData;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Age: " + age + ", Blood Data: " + bloodData.toString();
    }
}
