package linkedList;

import common.ListNode;

public class LinkedListAPalindrome {
    public static boolean isLinkedListAPalindrome (ListNode L) {
        if (L == null) return true;

        ListNode slow = L, fast = L;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverseHalf = reverse(slow);

        ListNode half = L;

        while (half != null && reverseHalf != null) {
            if (half.val != reverseHalf.val) return false;

            half = half.next;
            reverseHalf = reverseHalf.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode slow) {
        ListNode next = null, prev = null;

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(2);
        node.next.next = ch2;

        ListNode node2 = new ListNode(1);
        node.next.next.next = node2;

        System.out.println(isLinkedListAPalindrome(node));
    }
}
