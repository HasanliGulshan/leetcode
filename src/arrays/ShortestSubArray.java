package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> start  = new HashMap<>(), end  = new HashMap<>(), freq  = new HashMap<>();
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            start.putIfAbsent(nums[i], i);

            end.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

       int maxDegree = Collections.max(freq.values());

       for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
           int key = m.getKey();
           int value = m.getValue();
           if (value == maxDegree) {
               ans = Math.min(ans, end.get(key) - start.get(key) + 1);
           }
       }

       return ans;
    }

    public static void main(String[] args) {
       int[] n = new int[]{1,2,2,3,1};
        System.out.println(findShortestSubArray(n));
    }
}
