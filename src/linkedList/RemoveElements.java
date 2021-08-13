package linkedList;

import common.ListNode;

public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode node = head;
        ListNode prev = head;

        while (node.next != null) {

            if (node.next.next == null) {
                prev = node;
            }

            if (node.val == val) {
                node.val = node.next.val;
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        // 2 2 6 val = 6
        if (prev.val == val) {
            node = head;

            while (node != null) {

                if (node.next != null && node.next.val == val) {
                    node.next = null;
                    break;
                }
                node = node.next;
            }

            if (node == null)
                head = null;

        } else if (prev.next != null && prev.next.val == val) {
            prev.next = null;
        }

        return head;
    }

    /*public static ListNode removeElements(ListNode head, int val) {

        ListNode current = new ListNode(0, head);
        head = current;

        while(head != null) {
            if(head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }

        return current.next;
    }*/

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 3;

        ListNode ch1 = new ListNode(5);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

            ListNode node2 = new ListNode(2);
        node.next.next.next = node2;

       ListNode node3 = new ListNode(5);
        node.next.next.next.next = node3;

         ListNode node4 = new ListNode(55);
        node.next.next.next.next.next = node4;

       ListNode node5 = new ListNode(3);
        node.next.next.next.next.next.next = node5;

        ListNode in = removeElements(node, 3);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
