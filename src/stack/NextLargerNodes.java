package stack;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextLargerNodes {
    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new ArrayList<>();
        int[] ans = new int[getLength(head, list)];
        Deque<Integer> deque = new ArrayDeque<>();

        while (head != null) {
            if (!deque.isEmpty() && head.val > deque.peekFirst()) {

                while (!deque.isEmpty() && head.val > deque.peekFirst()) {
                    int index = list.indexOf(deque.pop());
                    list.set(index, -1);
                    ans[index] = head.val;
                }
            }

            deque.push(head.val);
            head = head.next;
        }

        for (int a : ans) System.out.print(a + " ");
        return ans;
    }

    public static int getLength(ListNode node, List<Integer> list) {
        int len = 0;

        while (node != null) {
            list.add(node.val);
            len++;
            node = node.next;
        }

        return len;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;

        ListNode ch1 = new ListNode(7);
        node.next = ch1;

        ListNode ch2 = new ListNode(5);
        node.next.next = ch2;

        ListNode node2 = new ListNode(1);
        node.next.next.next = node2;

        ListNode node3 = new ListNode(9);
        node.next.next.next.next = node3;

        ListNode node4 = new ListNode(2);
        node.next.next.next.next.next = node4;

        ListNode node5 = new ListNode(5);
        node.next.next.next.next.next.next = node5;

        ListNode node6 = new ListNode(1);
        node.next.next.next.next.next.next.next = node6;

        nextLargerNodes(node);
    }
}
