public class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);


        LinkedList list = new LinkedList();// Creating a linked list to add nodes to it
        list.head = node1;
        node1.next = node2;
        node2.next = node3;


        System.out.println("The Original List is:");
        printList(list.head);


        list.removeAfter(node1);
        System.out.println("\nAfter removing node after node1:");
        printList(list.head);


        LinkedList newList = list.copy();// Copying the list
        System.out.println("\nCopied List:");
        printList(newList.head);


        list.removeDuplicate("2");
        System.out.println("\nAfter removing duplicate nodes with item field equal to '2':");
        printList(list.head);// Removing duplicate nodes with item field equal to "2"


        int maxItem = list.max(list.head);// Finding the maximum item in the list
        System.out.println("\nMaximum item in the list: " + maxItem);
    }


    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
