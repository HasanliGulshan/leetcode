package binary_search;

import java.util.Arrays;

public class RangeSum {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        long M = 1000000007;
        int[] sums = new int[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            sums[index] = nums[i];
            for (int j = i + 1; j < n; j++) {
                int prevVal = sums[index];
                index++;
                sums[index] = prevVal + nums[j];
            }
            index++;
        }

        Arrays.sort(sums);
        int res = 0;
        left--;
        while (left < right) {
            res += sums[left];
            left++;
        }

        return (int) (res % M);
    }

    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4,1, 5));
    }
}
