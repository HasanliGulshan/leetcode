package heap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
       if (nums.length == k) return nums;

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> o1.getValue() >= o2.getValue() ? -1 : 1);

        for (int n : nums) map.put(n, map.getOrDefault(n, 0)  + 1);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
             queue.add(new Pair<>(m.getKey(), m.getValue()));
        }

        int[] ans = new int[k];
        int index = 0;

        while (!queue.isEmpty() && index < k) {
            ans[index++] = queue.poll().getKey();
        }

        for (int i : ans) System.out.print(i + " ");
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};

        topKFrequent(nums, 2);
    }
}
