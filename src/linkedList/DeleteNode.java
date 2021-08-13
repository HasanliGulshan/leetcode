package linkedList;

import common.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else{
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
