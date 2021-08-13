package linkedList;

import common.ListNode;

public class DecimalValue {
    public static int getDecimalValue(ListNode head) {
        ListNode node = head;
        int len = 0, decimal = 0;

        while (node != null) {
            len++;
            node = node.next;
        }

        len--;

        while (len >= 0) {
            decimal += head.val == 1 ? Math.pow(2, len) : 0;
            head = head.next;
            len--;
        }

        return decimal;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(0);
        node.next = ch1;

        ListNode ch2 = new ListNode(1);
        node.next.next = ch2;

        System.out.println(getDecimalValue(node));
    }
}
