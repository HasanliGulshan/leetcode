package linkedList;

import common.ListNode;

public class OverlappingNoCycleLists {
    public static ListNode overlappingNoCycleLists( ListNode LI, ListNode L2) {
        int l1Len = getLength(LI);
        int l2Len = getLength(L2);

        int diff = Math.abs(l1Len - l2Len);

        if (l1Len > l2Len) {
            LI = getKStepsAhead(diff, LI);
        } else {
            L2 = getKStepsAhead(diff, L2);
        }

        //no need to find min, bcs getKStepsAhead method already makes two list equal
        //int min = Math.min(l1Len, l2Len);

        /*while (min --> 0) {
            if (node1.val == node2.val) {
                return node1;
            }

            node1 = node1.next;
            node2 = node2.next;
        }*/

        //above while loop can be improved like this
        while (LI != null && L2 != null && LI.val != L2.val) {
            LI = LI.next;
            L2 = L2.next;
        }

        return LI;
    }

    public static ListNode getKStepsAhead(int k, ListNode node) {
        //does not modify LI or L2 if not assigned
        while (k--> 0) {
            node = node.next;
        }

        return node;
    }

    public static int getLength(ListNode node) {
        //does not modify LI or L2
        int len = 0;

        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 4;

        ListNode ch1 = new ListNode(1);
        node.next = ch1;

        ListNode ch2 = new ListNode(8);
        node.next.next = ch2;

        ListNode ch11 = new ListNode(4);
        node.next.next.next = ch11;

        ListNode ch22 = new ListNode(5);
        node.next.next.next.next = ch22;

        ListNode node2 = new ListNode();
        node2.val = 5;

        ListNode ch3 = new ListNode(6);
        node2.next = ch3;

        ListNode ch4 = new ListNode(1);
        node2.next.next = ch4;

        ListNode ch5 = new ListNode(8);
        node2.next.next.next = ch5;
        ListNode ch55 = new ListNode(4);
        node2.next.next.next.next = ch55;

        ListNode ch51 = new ListNode(5);
        node2.next.next.next.next.next = ch51;

        ListNode in = overlappingNoCycleLists(node, node2);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
