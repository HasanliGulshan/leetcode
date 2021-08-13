package arrays;

public class SumOfUnique {
    public static int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1)
                ans += nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,2};

        System.out.println(sumOfUnique(n));
    }
}
