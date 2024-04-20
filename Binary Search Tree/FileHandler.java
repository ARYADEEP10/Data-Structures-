import java.io.*;

public class FileHandler {
    private static final String FILENAME = "tree_state.ser";

    public static void saveTree(Node root) {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(root);
            System.out.println("\nTree saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tree: " + e.getMessage());
        }
    }

    public static Node loadTree() {
        Node root = null;
        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            root = (Node) in.readObject();
            System.out.println("Tree loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved tree found. Creating a new one.");
            root = TwentyQuestions.constructTree();
        }
        return root;
    }
}
