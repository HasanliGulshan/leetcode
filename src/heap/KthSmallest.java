package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] nums : matrix) {
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,5,9}, {10,11,13}, {12,13,15}};

        System.out.println(kthSmallest(matrix, 8));
    }
}
