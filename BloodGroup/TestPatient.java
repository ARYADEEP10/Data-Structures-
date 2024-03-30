// TestPatient.java
import java.util.Scanner;

public class TestPatient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Patient patient1 = new Patient(9876, 30, new BloodData());
        Patient patient2;
        Patient patient3;
//we initialise the values of patient 1 and 2 
        patient2 = new Patient(12345, 25, new BloodData(BloodType.A, '+'));

        System.out.print("Enter ID for Patient 3: ");
        int id = scanner.nextInt();
        System.out.print("Enter age for Patient 3: ");
        int age = scanner.nextInt();
        patient3 = new Patient(id, age, new BloodData());

        System.out.println("Patient 1: " + patient1);
        System.out.println("Patient 2: " + patient2);
        System.out.println("Patient 3: " + patient3);

        scanner.close();
    }
}
