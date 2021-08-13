package linkedList;


import common.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoSortedLists(ListNode LI,
                                                           ListNode L2) {
        // Creates a placeholder for the result.
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode pi = LI, p2 = L2;

        while (pi != null && p2 != null) {
            if (pi.val <= p2.val) {
                current.next = pi;
                pi = pi.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        // Appends the remaining nodes of pi or p2.
        current.next = pi != null ? pi : p2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 2;

        ListNode ch1 = new ListNode(5);
        node.next = ch1;

        ListNode ch2 = new ListNode(7);
        node.next.next = ch2;

        ListNode node2 = new ListNode();
        node2.val = 3;

        ListNode ch3 = new ListNode(11);
        node2.next = ch3;

        ListNode in= mergeTwoSortedLists(node, node2);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
