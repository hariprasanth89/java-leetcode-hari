package org.example.dinesh;

import java.util.List;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sentinel = new ListNode(0);
        ListNode n = sentinel;
        while (l1 != null || l2 != null) {
            int nval1 = (l1 != null)? l1.val : 0;
            int nval2 = (l2 != null)? l2.val : 0;

            int sum = carry + nval1 + nval2;
            carry = sum/10;

            n.next = new ListNode(sum%10);
            n = n.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry != 0)
            n.next = new ListNode(carry);

        return sentinel.next;
    }

    public static ListNode reverse(ListNode l) {
        ListNode prev = null, temp = null, curr = l;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static void printNodes(ListNode l) {
        ListNode curr = reverse(l);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode f1 = new ListNode(3);
        ListNode f2 = new ListNode(4, f1);
        ListNode f3 = new ListNode(2, f2);

        ListNode s1 = new ListNode(9);
        ListNode s2 = new ListNode(6, s1);
        ListNode s3 = new ListNode(5, s2);

        ListNode sum = addTwoNumbers(f3, s3);

        printNodes(f3);
        printNodes(s3);

        printNodes(sum);

    }
}
