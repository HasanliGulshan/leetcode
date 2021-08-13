package linkedList;

import common.ListNode;

public class RemoveNthFromEnd {
    //first solution
   /* public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            len++;
        }

        //there is just one element to remove so null
        if (len == 1) return null;

        int kTh = len - n;
        node = head;
        ListNode prev = head;

        while (node != null && kTh >=0) {

            if (kTh == 0) {
                if (node.next != null) {
                    node.val = node.next.val;
                    node.next = node.next.next;
                } else {
                    prev.next = null;
                }
            }

            if (kTh == 1) prev = node;

            node = node.next;
            kTh--;
        }

        return head;
    }*/

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode first = node.next;

        while (n --> 0) {
            first = first.next;
        }

        ListNode second = node;

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

           ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

    ListNode ch11 = new ListNode(4);
        node.next.next.next = ch11;

        ListNode ch22 = new ListNode(5);
        node.next.next.next.next = ch22; /**/

        ListNode in = removeNthFromEnd(node, 2);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
