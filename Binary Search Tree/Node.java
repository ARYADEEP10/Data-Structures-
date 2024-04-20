import java.io.Serializable;

public class Node implements Serializable {
    String data;
    Node left, right;

    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }
}
