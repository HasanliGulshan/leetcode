package heap;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val <= l2.val ? -1 : 1;
            }
        });

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
        }

        curr.next = null;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode res = new ListNode(-1);
        res.next = new ListNode(-1);
        res.next.next = new ListNode(-1);

        ListNode res1 = new ListNode(-2);
        res1.next = new ListNode(-2);
        res1.next.next = new ListNode(-1);

   /*     ListNode res2 = new ListNode(2);
        res2.next = new ListNode(6);*/

        ListNode[] arr = new ListNode[]{res, res1};

        ListNode ans = mergeKLists(arr);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
