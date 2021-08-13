package linkedList;

import common.ListNode;

public class DeleteDuplicatesLinked {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);

        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {

                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                pred.next = head.next;
            } else {
                pred = pred.next;
            }

            head = head.next;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode(3);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(4);
        node.next.next.next.next = node3;

        ListNode node4 = new ListNode(4);
        node.next.next.next.next.next = node4;

        ListNode node5 = new ListNode(5);
        node.next.next.next.next.next.next = node5;

        ListNode res = deleteDuplicates(node);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
