package arrays;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map1 : map.entrySet()) {
            int value = map1.getValue();

            ans += (value - 1) * value / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[] {4,6,5,2,3,2,2,5,3,3,6,1,2};
        System.out.println(numIdenticalPairs(n));
    }
}
