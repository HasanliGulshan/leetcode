package linkedList;

import common.ListNode;

public class DeleteDuplicates {
    public static  ListNode deleteDuplicates(ListNode head) {

         if (head == null) {
             return null;
         } else {
             ListNode temp = head;
             while (temp.next != null) {
                 if (temp.val == temp.next.val) {
                     temp.next = temp.next.next;
                 } else {
                     temp = temp.next;
                 }
             }
         }

         return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(2);
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

        System.out.println(deleteDuplicates(node));
    }
}
