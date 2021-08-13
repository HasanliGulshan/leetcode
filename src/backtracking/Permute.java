package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        perm(nums, 0, result);
        return result;
    }

    public static List<List<Integer>> perm(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            perm(nums, start + 1, result);
            swap(nums, start, i);
        }

        return result;
    }

    public static int[] swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        return nums;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1, 1, 2};

        System.out.println(permute(n));
    }
}
