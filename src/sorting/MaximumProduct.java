package sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            maxHeap.add(n);
            minHeap.add(n);
        }

        int min1 = minHeap.remove();
        int min2 = minHeap.remove();

        int max1 = maxHeap.remove();
        int max2 = maxHeap.remove();
        int max3 = maxHeap.remove();

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
