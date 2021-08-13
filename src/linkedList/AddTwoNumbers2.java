package linkedList;

import common.ListNode;

public class AddTwoNumbers2 {

    static ListNode res = null, tail = null;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode l1Reverse = reverse(l1);
         ListNode l2Reverse = reverse(l2);
         ListNode head = new ListNode(0, null);
         ListNode iterHead = head;

         int carry = 0, sum = 0;

         while (l1Reverse != null || l2Reverse != null) {
             sum = carry;

             if (l1Reverse != null) {
                 sum += l1Reverse.val;
                 l1Reverse = l1Reverse.next;
             }

             if (l2Reverse != null) {
                 sum += l2Reverse.val;
                 l2Reverse = l2Reverse.next;
             }

             ListNode curr = new ListNode(sum % 10);
             iterHead.next = curr;
             iterHead = curr;

             carry = sum/10;
         }

         if (carry > 0) {
             iterHead.next = new ListNode(carry, null);
         }

         return reverse(head.next);
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 7;

        ListNode ch1 = new ListNode(2);
        node.next = ch1;

        ListNode ch2 = new ListNode(4);
        node.next.next = ch2;

        ListNode node2 = new ListNode(3);
        node.next.next.next = node2;

        ListNode node22 = new ListNode();
        node22.val = 5;

        ListNode ch11 = new ListNode(6);
        node22.next = ch11;

        ListNode ch22 = new ListNode(4);
        node22.next.next = ch22;

        ListNode result = addTwoNumbers(node, node22);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
