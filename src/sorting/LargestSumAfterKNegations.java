package sorting;

import java.util.PriorityQueue;

public class LargestSumAfterKNegations {

    //wrong
    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;

        for (int n : nums) {
            minHeap.add(n);
        }

        while (!minHeap.isEmpty()) {
            if (k > 0) {
                sum += -1 * minHeap.remove();
            } else {
                sum += minHeap.remove();
            }

            k--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
    }
}
