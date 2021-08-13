package linkedList;

import common.ListNode;

public class HasCycle {
    static ListNode head;

    /*public static ListNode hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
// There is a cycle, so now let’s calculate the cycle length.
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);
// Finds the start of the cycle.
                ListNode cycleLenAdvancedlter = head;
// cycleLenAdvancedlter pointer advances cycleLen first.
                while (cycleLen-- > 0) {
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }
                ListNode iter = head;
// Both iterators advance in tandem.
                while (iter != cycleLenAdvancedlter) {
                    iter = iter.next;
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }
                return iter; // iter is the start of cycle.
            }
        }
        return null; // no cycle.
    }*/

    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) return null;

        //get start point of loop
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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


        push(1);
        push(2);


        head.next.next = head;


        ListNode in = hasCycle(head);

        while (in != null) {
            System.out.print(in.val + " ");
            in = in.next;
        }


    }
}
