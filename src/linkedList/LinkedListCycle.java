package linkedList;

import common.ListNode;

public class LinkedListCycle {
    static ListNode head;
    public static ListNode hasCycle(ListNode head) {
        ListNode q = head;
        ListNode p = head;

        while (q != null && p != null && q.next != null) {
            p = p.next;
            q = q.next.next;

            //references
            if (p == q) {
                return p;
            }
        }

        return null;
    }

    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {
        LinkedListCycle cycle = new LinkedListCycle();

        cycle.push(3);
        cycle.push(2);

        cycle.push(0);
        cycle.push(-4);

        cycle.head.next.next.next.next = cycle.head;


        System.out.println(hasCycle(head));
    }
}
