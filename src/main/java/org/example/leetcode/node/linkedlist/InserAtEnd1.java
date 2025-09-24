package org.example.leetcode.node.linkedlist;
// A linked list node
//class Node {
//    int data;
//    Node next;
//
//    // Constructor to initialize a new node with data
//    Node(int x) {
//        data = x;
//        next = null;
//    }
//}
public class InserAtEnd1 {



    // Given the head of a list and an int, appends
    // a new node at the end and returns the head.
    public static Node inserAtEnd(Node head, int x){
        Node newNode = new Node(x); // Create a new node


        // If the Linked List is empty, make
        // the new node as the head and return
        if(head == null){
            return newNode;
        }

        // Store the head reference in a temporary variable
        Node last = head;

        // Traverse the list till the last node
        while(last.next != null){
            last = last.next;
        }
        // Change the next pointer of the last node
        // to point to the new node
        last.next = newNode;
        return head; // Return the head of the list
    }

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        // Create a linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = inserAtEnd(head, 6);

        printList(head);
    }

}
