package org.example.leetcode.node.reverselinked;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize a pointer to the previous node, initially null
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save the next node before reversing the link
            curr.next = prev;  // Reverse the link to the previous node
            prev = curr; // Move the previous pointer to the current node
            curr = nextTemp; // Move the current pointer to the next node
            }
        return prev; // Return the new head of the reversed linked list
    }

    /**
     * Brute-force approach to reverse a linked list.
     * This method involves iterating through the list, storing values in an array,
     * and then creating a new linked list in reverse order from the array.
     * This approach uses O(N) space for the array and O(N) time for two passes.
     *
     * @param head The head of the input linked list.
     * @return The head of the reversed linked list.
     */
    public static ListNode reverseListBruteForce(ListNode head) {
        if (head == null || head.next == null) {
            return head; // An empty list or a single-node list is already reversed
        }

        // Step 1: Traverse the list and store node values in an array
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // Step 2: Create a new linked list in reverse order from the array
        ListNode newHead = new ListNode(values.get(values.size() - 1)); // Start with the last element
        ListNode newCurrent = newHead;
        for (int i = values.size() - 2; i >= 0; i--) {
            newCurrent.next = new ListNode(values.get(i));
            newCurrent = newCurrent.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head);

        // Optimized solution
        ListNode optimizedReversedHead = reverseList(head);
        System.out.print("Optimized Reversed list: ");
        printList(optimizedReversedHead);

        // Brute-force solution (re-create the original list for demonstration)
        ListNode headBruteForce = new ListNode(1);
        headBruteForce.next = new ListNode(2);
        headBruteForce.next.next = new ListNode(3);
        headBruteForce.next.next.next = new ListNode(4);
        headBruteForce.next.next.next.next = new ListNode(5);

        ListNode bruteForceReversedHead = reverseListBruteForce(headBruteForce);
        System.out.print("Brute-force Reversed list: ");
        printList(bruteForceReversedHead);
    }

    private static void printList(ListNode reversedHead) {
        ListNode cur = reversedHead;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

}
