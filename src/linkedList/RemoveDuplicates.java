package linkedList;

import common.ListNode;

public class RemoveDuplicates {
    //first
   /* public static ListNode removeDuplicates (ListNode L) {
        ListNode iter = L;

        while (iter != null) {
            //if is true change iter next reference to iter.next.next
            if (iter.next != null && iter.val == iter.next.val) {
                iter.next = iter.next.next;
            } else {
                //if is false then do not modify object just pass
                iter = iter.next;
            }
        }

        return L;
    }*/

   //second
    public static ListNode removeDuplicates(ListNode L) {
        ListNode iter = L;

        while (iter != null) {
            // Uses nextDistinct to find the next distinct value.
            ListNode nextDistinct = iter.next;
            while (nextDistinct != null && nextDistinct.val == iter.val) {
                nextDistinct = nextDistinct.next;
            }
            iter.next = nextDistinct;
            //i this assign is not there, then next time iter.next will always be nextDistinct and wont progress
            iter = nextDistinct;
        }

        return L;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(1);
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

        ListNode node6 = new ListNode(5);
        node.next.next.next.next.next.next.next = node6;

        ListNode res = removeDuplicates(node);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
