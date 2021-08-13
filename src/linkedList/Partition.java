package linkedList;

import common.ListNode;

public class Partition {

    //combining lists takes O(1) time, overall O(n)
    public static ListNode listPivoting(ListNode L, int x) {
        if (L == null) return null;

        ListNode node = L;

        ListNode lessThan = new ListNode(0, null);
        ListNode prevLess = lessThan;
        ListNode equalOrGreater = new ListNode(0, null);
        ListNode prevEqual = equalOrGreater;

        while (node != null) {
            if (node.val < x) {
                prevLess.next = node;
                prevLess = node;
            } else {
                prevEqual.next = node;
                prevEqual = node;
            }

            node = node.next;
        }

        //get rid of 0
        equalOrGreater = equalOrGreater.next;

        //end equal with null value
        prevEqual.next = null;

        //combine two list
        prevLess.next = equalOrGreater;

        return lessThan.next;
    }

    //second
   /* public static ListNode listPivoting(ListNode L, int x) {
        ListNode lessHead = new ListNode(0, null);
        ListNode equalHead = new ListNode(0, null);
        ListNode greaterHead = new ListNode(0, null);
        ListNode lesslter = lessHead;
        ListNode equallter = equalHead;
        ListNode greaterlter = greaterHead;
// Populates the three lists.
        ListNode iter = L;
        while (iter != null) {
            if (iter.val < x) {
                lesslter.next = iter;
                lesslter = iter;
            } else if (iter.val == x) {
                equallter.next = iter;
                equallter = iter;
            } else { // iter.data > x.
                greaterlter.next = iter;
                greaterlter = iter;
            }
            iter = iter.next;
        }
// Combines the three lists.
        greaterlter.next = null;
        equallter.next = greaterHead.next;
        lesslter.next = equalHead.next;
        return lessHead.next;
    } */

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

/*        ListNode ch1 = new ListNode(4);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode(2);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(5);
        node.next.next.next.next = node3;

        ListNode node4 = new ListNode(2);
        node.next.next.next.next.next = node4;*/

        ListNode in = listPivoting(node, 0);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
