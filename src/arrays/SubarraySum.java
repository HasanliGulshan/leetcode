package arrays;

import java.util.HashMap;

public class SubarraySum {

    //T.C O(n^2) S.C O(1)
  /*  public static int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }

        }

        return count;
    } */


    // T.C O(n) S.C O(n)
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] n = new int[] {1,2,3};

        //{100,1,2,3,4};
        System.out.println(subarraySum(n, 3));
    }
}
