public class TwentyQuestions {
    private static final String FILENAME = "tree_state.ser";

    public static Node constructTree() {
        Node root = new Node("Is it an animal?");
        root.left = new Node("Does it have four legs?");
        root.right = new Node("Does it fly?");
        root.left.left = new Node("Is it a dog?");
        root.left.right = new Node("Is it a cat?");
        root.right.left = new Node("Is it a bird?");
        root.right.right = new Node("Is it a fish?");
        return root;
    }

    public static void main(String[] args) {
        Node root = FileHandler.loadTree();
        Game.playGame(root);
        FileHandler.saveTree(root);
    }
}
