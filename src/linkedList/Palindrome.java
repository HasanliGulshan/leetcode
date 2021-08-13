package linkedList;

import common.ListNode;


public class Palindrome {
    static ListNode curr;
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        curr = head;

        return recur(head);
    }

    static boolean recur(ListNode node) {
        if (node == null)
            return true;

        boolean res = recur(node.next) && (node.val == curr.val);
        curr = curr.next;

        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

       /* ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode(4);
        node.next.next.next = node2;*/

        System.out.println(isPalindrome(node));
    }
}
