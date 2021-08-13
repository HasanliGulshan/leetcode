package sorting;

import java.util.*;

public class MinSubsequence {
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalSum = 0, localSum = 0;

        for (int n : nums) {
            totalSum += n;
            maxHeap.add(n);
        }

        while (localSum <= totalSum) {
            int value = maxHeap.remove();
            localSum += value;
            totalSum -= value;
            list.add(value);
        }

        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        minSubsequence(new int[]{4,4,7,6,7});
    }
}
