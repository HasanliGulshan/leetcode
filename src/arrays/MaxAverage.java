package arrays;

public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double max = 0, sum = 0;
        int i = 0;

        for (i = 0; i < k; i++) sum += nums[i];

        max = sum / k;

        for (int j = i; j < nums.length; j++) {
            sum += nums[j] - nums[j - k];
            max = Math.max(sum / k, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(n, 4));
    }
}
