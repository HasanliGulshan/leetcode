package heap;

import java.util.*;

public class TopK {
    public static List<String> topK(int k, Iterator<String> iter) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(String::length));

        while (iter.hasNext()) {
            minHeap.add(iter.next());
            if (minHeap.size() > k) {
                    // Remove the shortest string. Note that the comparison function above
                    // will order the strings by length.
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}
