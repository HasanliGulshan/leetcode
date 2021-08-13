package linkedList;

import common.ListNode;

public class AddTwoNumbersEPI {
    public static ListNode addTwoNumbers(ListNode LI, ListNode L2) {
        ListNode head = new ListNode(0, null);
        ListNode iterHead = head;
        int carry = 0, sum = 0;

        while (LI != null || L2 != null) {
            sum = carry;

            if (LI != null) {
            sum = carry + LI.val;
            LI = LI.next;
            }


            if (L2 != null) {
                sum += L2.val;
                L2 = L2.next;
            }

            ListNode item = new ListNode(sum % 10);
            iterHead.next = item;
            iterHead = item;

            carry = sum / 10;
        }

        if (carry > 0) {
            iterHead.next = new ListNode(sum);;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 2;

        ListNode ch1 = new ListNode(4);
        node.next = ch1;

        ListNode ch2 = new ListNode(3);
        node.next.next = ch2;

        ListNode node2 = new ListNode();
        node2.val = 5;

        ListNode ch3 = new ListNode(6);
        node2.next = ch3;

        ListNode ch4 = new ListNode(4);
        node2.next.next = ch4;

        ListNode in = addTwoNumbers(node, node2);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }
    }
}
