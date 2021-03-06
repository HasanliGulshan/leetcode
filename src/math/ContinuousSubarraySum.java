package math;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k > 0) sum %= k;

            if (map.containsKey(sum)) {
                if ((i - map.get(sum)) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23, 2, 4, 6, 7};

        System.out.println(checkSubarraySum(nums, 0));
    }
}
