package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sorted = new int[nums.length];
        int j = 0;

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                if (a.getKey() < b.getKey()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return a.getValue() - b.getValue();
            }
        });

        priorityQueue.addAll(map.entrySet());

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> item = priorityQueue.poll();
            int value = item.getValue();
            int key = item.getKey();

            while (value > 0) {
                sorted[j++] = key;
                value--;
            }
        }

        for (int s : sorted) System.out.print(s + " ");

        return sorted;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,1,2,2,2,3};
        System.out.println(frequencySort(n));
    }
}
