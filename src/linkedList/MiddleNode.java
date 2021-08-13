package linkedList;

import common.ListNode;

public class MiddleNode {
    public static ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode node = head;

        while (node != null) {
            len++;
            node = node.next;
        }

        len = len/2;

        while (len > 0) {
            head = head.next;
            len--;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode ch3 = new ListNode(4);
        node.next.next.next = ch3;

        ListNode ch4 = new ListNode(5);
        node.next.next.next.next = ch4;

        ListNode ch5 = new ListNode(6);
        node.next.next.next.next.next = ch5;

        ListNode in = middleNode(node);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
