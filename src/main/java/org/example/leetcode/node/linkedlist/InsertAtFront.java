package org.example.leetcode.node.linkedlist;


class Node {
    int data;
    Node next;

    // Constructor to initialize the node
    Node(int x) {
        data = x;
        next = null;
    }
}
public class InsertAtFront {


    // Function to insert a new node at
    // the beginning of the list
    public static Node insertAtFront(Node head, int x){
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }
    // Function to print the contents
    // of the linked list
  public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        insertAtFront(head, 10);
        printList(head);
    }



}
