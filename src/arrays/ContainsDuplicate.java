package arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
           if (map.containsKey(nums[i])) {
               Integer v = map.get(nums[i]);
               v += 1;
               map.put(nums[i], v);
           } else {
               map.put(nums[i], 1);
           }
       }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) return true;
        }
       return false;
    }

    public static void main(String[] args) {
      int[] nums = new int[] {21, 2, 3, 21};
        System.out.println(containsDuplicate(nums));
    }
}
