package linkedList;

import common.ListNode;

public class ReverseBetween {
    /*public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode start = head;
        int k = 1;

        while (k < left) {
            start = start.next;
            k++;
        }

        ListNode subList = new ListNode(0);
        ListNode item = subList;
        int l = left;

        while (start != null && l <= right) {
            //make deep copy, so when you reverse it there will not be any change in original head
            item.next = new ListNode(start.val);
            start = start.next;
            item = item.next;
            l++;
        }

        item.next = null;

        //reverse sublist
        ListNode rSubList = null;
        ListNode next = null;

        //get rid of 0
        subList = subList.next;

        while (subList != null) {
            next = subList.next;
            subList.next = rSubList;
            rSubList = subList;
            subList = next;
        }

        //combine lists
        ListNode dummyHead = new ListNode(0);
        ListNode item2 = dummyHead;
        k = 1;

        while (head != null) {
            if (k == left && rSubList != null) {

            while (rSubList != null) {
                item2.next = rSubList;
                rSubList = rSubList.next;
                item2 = item2.next;
            }

        } else {
                item2.next = head;
                head = head.next;
                item2 = item2.next;
                k++;

            }
        }

        return dummyHead.next;
    }*/

    public static ListNode reverseSublist(ListNode L, int start,
                                          int finish) {
        if (start == finish) { // No need to reverse since start == finish.
            return L;
        }

        ListNode dummyHead = new ListNode(0, L);
        ListNode sublistHead = dummyHead;
        int k = 1;

        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        // Reverse sublist.
        ListNode sublistlter = sublistHead.next;

        while (start++ < finish) {
            ListNode temp = sublistlter.next;
            sublistlter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode(4);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(5);
        node.next.next.next.next = node3;

        ListNode in = reverseSublist(node, 2, 4);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
