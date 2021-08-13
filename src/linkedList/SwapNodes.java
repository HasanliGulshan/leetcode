package linkedList;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodes {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode copyHead = head;
        ListNode prev = head;
        List<Integer> list = new ArrayList<>();

        while (copyHead != null) {
            list.add(copyHead.val);
            copyHead = copyHead.next;
        }

        int lastKIndex = list.size() - k;
        int temp = list.get(k - 1);
        int lastKValue =  list.get(lastKIndex);
        list.set(k - 1, lastKValue);
        list.set(lastKIndex, temp);

        int index = 0;

        while (prev != null) {
            prev.val = list.get(index);
            prev = prev.next;

            index++;
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

        ListNode node2 = new ListNode(4);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(5);
        node.next.next.next.next = node3;

        swapNodes(node, 2);
    }
}
