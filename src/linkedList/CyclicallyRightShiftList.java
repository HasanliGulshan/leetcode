package linkedList;

import common.ListNode;

public class CyclicallyRightShiftList {

    //first
    /*public static ListNode cyclicallyRightShiftList(ListNode L, int k){
        if (L == null) return null;

        int len = getLength(L);
        k = k % len;

//there is no enaugh elem to rotate
        if (len == 1 || k == 0) return L;

        int subLen = len - k;

        ListNode node = L;

        while (subLen --> 1) {
            node = node.next;
        }

        ListNode subTail = node.next;
        node.next = null;
        ListNode iterTail = subTail;

        while (iterTail.next != null) {
            iterTail = iterTail.next;
        }

        iterTail.next = L;

        return subTail;
    }*/

    //second
    public static ListNode cyclicallyRightShiftList(ListNode L, int k) {
        if (L == null) {
            return L;
        }
// Computes the length of L and the tail.
        ListNode tail = L;
        int n = 1;
        while (tail.next != null) {
            ++n;
            tail = tail.next;
        }
        k %= n;
        if (k == 0){
            return L;
        }
        tail.next = L; // Makes a cycle by connecting the tail to the head.
        int stepsToNewHead = n - k;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static int getLength(ListNode node) {
        int len = 0;

        while (node != null) {
            node = node.next;
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(12);
        node.next = ch1;

    /*    ListNode ch2 = new ListNode(2);
        node.next.next = ch2;

        ListNode node2 = new ListNode(4);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(5);
        node.next.next.next.next = node3;*/

        ListNode in = cyclicallyRightShiftList(node, 2);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
