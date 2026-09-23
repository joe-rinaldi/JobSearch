package main.examples;

// Complete Java program to reverse a linked list
public class ReverseLinkedList {

    // Node class for singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to reverse the linked list iteratively
    public static Node reverseIterative(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // Store next node
            current.next = prev;   // Reverse the link
            prev = current;        // Move prev forward
            current = next;        // Move current forward
        }
        return prev; // New head
    }

    // Function to reverse the linked list recursively
    public static Node reverseRecursive(Node head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head; // Reverse the link
        head.next = null;      // Avoid cycle
        return newHead;
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        // Iterative reversal
        head = reverseIterative(head);
        System.out.println("Reversed List (Iterative):");
        printList(head);

        // Reverse back using recursion
        head = reverseRecursive(head);
        System.out.println("Reversed List (Recursive):");
        printList(head);
    }
}
