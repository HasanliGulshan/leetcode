package heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortApproximatelySortedData {
    public static void sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Adds the first k elements into minHeap. Stop if there are fewer than k
        // elements .
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            minHeap.add(sequence.next());
        }
        // For every new element, add it to minHeap and extract the smallest.
        while (sequence.hasNext()) {
            Integer smallest = minHeap.remove();
            System.out.print(smallest + " ");
            minHeap.add(sequence.next());
        }

        // sequence is exhausted, iteratively extracts the remaining elements.
        while (!minHeap.isEmpty()) {
            Integer smallest = minHeap.remove();
            System.out.print(smallest + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(-1);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(8);

        sortApproximatelySortedData(list.iterator(), 2);
    }
}
