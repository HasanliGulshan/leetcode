package sorting;

import java.util.Arrays;

public class SortArray {
    public static int[] sortArray(int[] nums) {
        Arrays.sort(nums);

        for (int n : nums) System.out.print(n + " ");

        return nums;
    }

    public static void main(String[] args) {
        sortArray(new int[]{5,1,1,2,0,0});
    }
}
