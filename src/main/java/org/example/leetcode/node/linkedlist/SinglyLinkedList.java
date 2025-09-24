package org.example.leetcode.node.linkedlist;

public class SinglyLinkedList {

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String[] args) {
      Node head = new Node(10);
      head.next = new Node(20);
      head.next.next = new Node(30);
      head.next.next.next = new Node(40);
      head.next.next.next.next = new Node(50);
        traverseList(head);
    }

    public static void traverseList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            //System.out.println(head.next.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
