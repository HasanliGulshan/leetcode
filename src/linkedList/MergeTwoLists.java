package linkedList;

import common.ListNode;

public class MergeTwoLists {
    public static void  printNode(ListNode node) {
        ListNode curr = node;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        } else  if (l1 == null || l2 == null) {
            return l1==null?l2:l1;
        } else {
            ListNode head = new ListNode(0);
            ListNode prev = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    prev = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    prev = l2;
                    l2 = l2.next;
                }
            }

            ListNode temp = l1 == null?l2:l1;

            while (temp != null) {
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            }

            return head.next;
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(4);
        node.next.next = ch2;

        ListNode node2 = new ListNode();
        node2.val = 1;

        ListNode ch3 = new ListNode(3);
        node2.next = ch3;

        ListNode ch4 = new ListNode(4);
        node2.next.next = ch4;

        mergeTwoLists(node, node2);
    }
}
