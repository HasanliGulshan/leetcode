package linkedList;

import common.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= null;
        ListNode prev = null;

        int temp = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(temp % 10);
            temp = temp / 10;

            if (prev == null) {
                prev = node;
                head = node;
            } else {

                prev.next = node;//this line refer to same obj as head

//prev.next and prev refer to same node as in if condition, so we can conclude that prev also refer to prev.next which refer to head

                prev = node; //refer to new node ; second line will be 0 for this example next iteration will be 0, 8 or
              //  prev = prev.next; this two work correct
            }
        }

        if (temp != 0) {
           // ListNode node = ;
            prev.next = new ListNode(temp);
        }

        printNode(head);
        return head;
    }

    public static void  printNode(ListNode node) {
        ListNode curr = node;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static void main (String[]args){
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

            addTwoNumbers(node, node2);
        }
    }

