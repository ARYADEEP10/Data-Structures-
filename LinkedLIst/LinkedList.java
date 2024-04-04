public class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }


    void removeAfter(Node node) {
        if (node == null || node.next == null)// Below is the method to remove the node following the given one
            return;
        node.next = node.next.next;
    }


    LinkedList copy() {
        LinkedList newList = new LinkedList();//  creating a copy of the linked list
        Node current = this.head;
        Node newHead = null;
        Node tail = null;

        while (current != null) {
            Node newNode = new Node(current.data);
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            current = current.next;
        }
        newList.head = newHead;
        return newList;
    }


    void removeDuplicate(String key) {// Removing  nodes with item field equal to key
        if (head == null)
            return;

        Node current = head;
        while (current.next != null) {
            if (current.next.data == Integer.parseInt(key)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }


    int max(Node node) {// finding the maximum item in the list using while loop
        int max = 0;
        while (node != null) {
            if (node.data > max)
                max = node.data;
            node = node.next;
        }
        return max;
    }
}
