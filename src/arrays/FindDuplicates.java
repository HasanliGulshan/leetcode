package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                list.add(index + 1);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        int[] n = new int[]{10,2,5,10,9,1,1,4,3,7};
        System.out.println(findDuplicates(n));
    }
}
