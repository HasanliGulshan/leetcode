package bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    static List<List<Integer>> res = new ArrayList<>();

    /*public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item;

        for (int i= 0; i < Math.pow(2, nums.length); i++) {
            item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int h = 1 << j;

                if ((i & h) != 0) {
                    item.add(nums[j]);
                }
            }

            Collections.sort(item);
            if (!res.contains(item))
                 res.add(item);
        }

        return res;
    }
*/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(res, nums, 0, temp);
        return res;
    }

    public static void generateSubset(List<List<Integer>> res, int[] nums, int index, List<Integer> temp) {
        if (temp.size() > nums.length) return;

        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (index != i && nums[i - 1] == nums[i])
                continue;

                temp.add(nums[i]);

            generateSubset(res, nums, i + 1, temp);
        }

        if (temp.size() != 0)
            temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(num));
    }
}
