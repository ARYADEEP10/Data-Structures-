
import java.util.Scanner;

public class SquareRootException {
    public static void main(String[] args) {
        //We Try block to attempt taking the square root of a user-input value
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number to calculate its square root: ");
            double userInput = scanner.nextDouble();

            // Check if the input is negative, and throw ArithmeticException if true
            if (userInput < 0) {
                throw new ArithmeticException("Cannot calculate square root of a negative number");
            }

            // Calculate and display the square root
            double squareRoot = Math.sqrt(userInput);
            System.out.println("Square root: " + squareRoot);
        } catch (ArithmeticException e) {
            // Catch block to handle ArithmeticException
            System.out.println("Error: " + e.getMessage());
        }
    }
}
