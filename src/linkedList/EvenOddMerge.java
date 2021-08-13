package linkedList;

import common.ListNode;

import java.util.Arrays;
import java.util.List;

public class EvenOddMerge {
   /* public static ListNode evenOddMerge(ListNode L) {
        if (L == null) return null;

        ListNode node = L;

        ListNode even = null;
        ListNode prev_even = null;
        ListNode odd = null;
        ListNode prev_odd = null;
        boolean isEven = true;

        while (node != null) {
            if (isEven) {
                if (even == null) {
                    even = new ListNode(node.val);
                    prev_even = even;
                } else {
                    prev_even.next = node;
                    prev_even = prev_even.next;
                }
            } else {
                if (odd == null) {
                    odd = new ListNode(node.val);
                    prev_odd = odd;
                } else {
                    prev_odd.next = node;
                    prev_odd = prev_odd.next;
                }
            }
            node = node.next;
            isEven = !isEven;
        }

        if (prev_odd != null)
            prev_odd.next = null;

        prev_even.next = odd;

        return even;
    }*/

   //second
   public static ListNode evenOddMerge (ListNode L) {
       if (L == null) {
           return null;
       }

       ListNode evenDummyHead = new ListNode(0 ,null),
       oddDummyHead = new ListNode(0, null);
       List<ListNode> tails = Arrays.asList(evenDummyHead, oddDummyHead);
       int turn = 0;

       for (ListNode iter = L; iter != null; iter = iter.next) {
           tails.get(turn).next = iter;
           tails.set(turn, tails.get(turn).next);
           turn ^= 1;
       }

       tails.get(1).next = null;
       tails.get(0).next = oddDummyHead.next;

       return evenDummyHead.next;
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

        ListNode in = evenOddMerge(node);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
