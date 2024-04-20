import java.util.Scanner;

public class Game {
    private static final int MAX_QUESTIONS = 20;

    public static void playGame(Node root) {
        Scanner scanner = new Scanner(System.in);
        Node current = root;
        int questionCount = 0;

        System.out.println("Welcome to the 20 Questions Game! Think of an object, and I'll try to guess what it is.");

        while (current.left != null && current.right != null && questionCount < MAX_QUESTIONS) {
            System.out.println("\n" + current.data + " (yes/no): ");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                current = current.left;
            } else if (answer.equals("no")) {
                current = current.right;
            } else {
                System.out.println("I didn't get that. Please answer with 'yes' or 'no'.");
                continue;
            }
            questionCount++;
        }

        if (questionCount == MAX_QUESTIONS) {
            System.out.println("\nI give up! You win! Please tell me the correct answer.");
            String correctAnswer = scanner.nextLine();
            System.out.println("Great! Now, provide a question to distinguish " + correctAnswer + " from my guess.");
            String newQuestion = scanner.nextLine();
            current.data = newQuestion;
            System.out.println("What is the answer for " + correctAnswer + "? (yes/no)");
            String newAnswer = scanner.nextLine().toLowerCase();
            current.left = new Node(correctAnswer);
            current.right = new Node(newAnswer);
        } else {
            System.out.println("\nIs it " + current.data + "? (yes/no): ");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals("yes")) {
                System.out.println("\nHooray! I win! Thanks for playing!");
            } else {
                System.out.println("\nAww, you win! Let me learn from my mistake.");
                System.out.println("What question would distinguish your object from mine?");
                String newQuestion = scanner.nextLine();
                System.out.println("What is the answer for your object? (yes/no)");
                String newAnswer = scanner.nextLine().toLowerCase();
                current.data = newQuestion;
                current.left = new Node(current.data);
                current.right = new Node(newAnswer);
                System.out.println("Thanks for teaching me! Let's play again sometime!");
            }
        }
    }
}
