package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] ans = new int[nums.length];
        int h = 0;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else
                map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
        }
        Arrays.sort(nums);
        System.out.println(map);

       for (int i = 0; i < nums.length;) {
           int j = i;

           for (int k : map.get(nums[i])) {
               System.out.println("k = " + k);
               ans[k] = j;
               i++;
           }
       }

        return ans;
    }


    public static void main(String[] args) {
        int[] n = new int[]{8, 1, 2, 2, 3};
        smallerNumbersThanCurrent(n);
    }
}
