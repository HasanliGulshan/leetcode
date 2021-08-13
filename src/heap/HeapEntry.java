package heap;

import java.util.*;

public class HeapEntry {
    public Integer index;
    public Integer value;

    public HeapEntry(Integer index, Integer value) {
        this.index = index;
        this.value = value;

    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry ol, HeapEntry o2) {
            return Integer.compare(o2.value, ol.value);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static List<Integer> kLargestlnBinaryHeap(List<Integer> A, int k) {
        if (k <= 0) {
            return Collections.EMPTY_LIST;
        }
        // Stores the (index, value)-pair in candidateMaxHeap. This heap is
        // ordered by the value field.
        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Compare.COMPARE_HEAP_ENTRIES);
        candidateMaxHeap.add(new HeapEntry(0, A.get(0)));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            //peek O(1) t.c no need to extract obj
            Integer candidateldx = candidateMaxHeap.peek().index;
            //remove O(log(n))
            result.add(candidateMaxHeap.remove().value);
            Integer leftChildldx = 2 * candidateldx + 1;
            if (leftChildldx < A.size()) {
                candidateMaxHeap.add(new HeapEntry(leftChildldx, A.get(leftChildldx)));
            }
            Integer rightChildldx = 2 * candidateldx + 2;
            if (rightChildldx < A.size()) {
                candidateMaxHeap.add(
                        new HeapEntry(rightChildldx, A.get(rightChildldx)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(561);
        list.add(314);
        list.add(401);
        list.add(28);
        list.add(156);
        list.add(359);
        list.add(271);
        list.add(11);
        list.add(3);

        System.out.println(kLargestlnBinaryHeap(list, 4));
    }
}
