package arrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        while (i < nums.length) {
            if (nums[i] == 1) {
                count++;
                i++;
                continue;
            }

            if (count != 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                i++;
            }

        }

        if (count != 0)
            max = Math.max(max, count);

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] n = new int[]{0};
        System.out.println(findMaxConsecutiveOnes(n));
    }
}
