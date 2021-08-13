package bits;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static List<List<Integer>> res = new ArrayList<>();

    //using bit manipulation
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = null;

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int h = 1 << j;

                if ((i & h) != 0)
                    item.add(nums[j]);
            }

            res.add(item);
        }

        return res;
    }

    //using backtracking
    public static List<List<Integer>> subsets2(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        generateSubset(res, nums, 0, temp);
        return res;
    }

    public static void generateSubset(List<List<Integer>> res, int[] nums, int index, List<Integer> temp) {
        if (temp.size() > nums.length) return;

        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);

            generateSubset(res, nums, i + 1, temp);
        }

        if (temp.size() != 0)
            temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{55, 2, 3};
        System.out.println(subsets2(a));

    }
}
