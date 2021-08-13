package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList list = new ArrayList<Integer>();
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] ++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                System.out.println("i " + count[i] + " " + i);
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] n = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(n));
    }
}
