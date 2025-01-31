public class CircularLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        Node n = head;
        do {
            System.out.print(n.data + " ");
            n = n.next;
        } while (n != head);
        System.out.println();
    }

    public void insertAtHead(int data) {
        if (head == null) {
            Node new_node = new Node(data);
            new_node.next = new_node;
            head = new_node;
        } else {
            Node new_node = new Node(data);
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            new_node.next = head;
            head = new_node;
            temp.next = head;
        }
    }

    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtEnd(int new_data) {
        if (head == null) {
            Node new_node = new Node(new_data);
            new_node.next = new_node;
            head = new_node;
        } else {
            Node new_node = new Node(new_data);
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
        }
    }

    public void deleteStart() {
        if (head == null) {
            System.out.println("Empty Linked List");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Empty linked list");
            return;
        }
        Node temp = head;

        if (position == 0) {
            deleteStart();
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == head) {
            System.out.println("Position does not exist");
            return;
        }
        Node next = temp.next.next;
        if (temp.next == head) {
            temp.next = head;
        } else {
            temp.next = next;
        }
    }
    public static void main(String[] args) {
        CircularLinkedList cllist = new CircularLinkedList();
        cllist.insertAtEnd(2);
        cllist.insertAtEnd(6);
        cllist.insertAtEnd(9);
        System.out.println("Circular Linked List:");
        cllist.printList();
        cllist.insertAtHead(1);
        System.out.println("After inserting 1 at head:");
        cllist.printList();
        cllist.deleteStart();
        System.out.println("After deleting from start:");
        cllist.printList();
        cllist.deleteEnd();
        System.out.println("After deleting from end:");
        cllist.printList();
        cllist.deleteAtPosition(1); // Deleting node at position 1
        System.out.println("After deleting node at position 1:");
        cllist.printList();
        cllist.deleteAtPosition(0); // Deleting node at position 0
        System.out.println("After deleting node at position 0:");
        cllist.printList();
    }
}