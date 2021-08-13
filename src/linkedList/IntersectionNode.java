package linkedList;

import common.ListNode;

public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {


            ListNode currA = headA;
            ListNode currB = headB;

            int currALen = getLength(currA);
            int curBLen = getLength(currB);

            int diff = Math.abs(currALen - curBLen);
            currA = headA;
            currB = headB;
            if (currALen > curBLen) {
                while (diff-- > 0) currA = currA.next;
            } else {
                while (diff-- > 0) currB = currB.next;
            }

            int min = Math.min(currALen, curBLen);

            while (min-- > 0) {
                //reference equal, not value of node
                if (currA == currB) {
                    return currA;
                }

                currA = currA.next;
                currB = currB.next;
            }

            return null;

    }

    static int getLength(ListNode node) {
        int len = 0;

        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }
    public static void printNode(ListNode node) {
        ListNode curr = node;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
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

        printNode(getIntersectionNode(node, node2));
    }
}
