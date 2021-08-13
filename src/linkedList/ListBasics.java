package linkedList;

import common.ListNode;
import common.ListNodeEpi;

public class ListBasics {
    public static ListNodeEpi<Integer> search(ListNodeEpi<Integer> L, int key) {
        while (L != null && L.data != key) {
            L = L.next;
        }
// If key was not present in the list, L will have become null.
        return L;
    }
}
