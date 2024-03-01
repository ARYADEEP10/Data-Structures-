import java.util.Scanner;

public class CaughtBadSubscript {
    public static void main(String[] args) {
        // Declare an array of 10 first names
        String[] firstNames = {"John", "Alice", "Bob", "Charlie", "David", "Ava", "Frank", "Grace", "Harry", "Ivy"};

        // Try block to prompt the user for an integer and display the name at the requested position
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the position (0-9) to display the name: ");
            int position = scanner.nextInt();

            // Display the name at the requested position
            System.out.println("Name at position " + position + ": " + firstNames[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block to handle ArrayIndexOutOfBoundsException
            System.out.println("Error: Array index out of bounds. Please enter a valid position (0-9).");
        }
    }
}
