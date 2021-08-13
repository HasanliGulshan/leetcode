package linkedList;

import common.ListNode;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next; //points to head.next
            head.next = prev; //now head.next points to prev to reverse
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode(4);
        node.next.next.next = node2;

        ListNode reversed = reverseList(node);

        while (reversed!= null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
