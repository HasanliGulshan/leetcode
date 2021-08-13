package arrays;

public class Rotate {
    /*public static void rotate(int[] nums, int k) {
            k = (k > nums.length) ? k % nums.length : k;

            int[] ans = new int[nums.length];
            int i = 0, count = k - 1;

            for (int j = nums.length - 1; j >= 0 && count >= 0; j--, count--) {
                ans[count] = nums[j];
            }

            for (int j = k; j < ans.length && i < nums.length - count; j++, i++) {
                ans[j] = nums[i];
            }

            for (i = 0; i < ans.length; i++)
                nums[i] = ans[i];

            for (int n : nums) System.out.print(n + " ");
    }*/

    public static void rotate(int[] nums, int k) {
        //nums = 1, 2, 3, 4, 5, 6, 7
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);  // -> 7, 6, 5, 4, 3, 2, 1
        reverse(nums, 0, k - 1); // -> 5, 6, 7, 4, 3, 2, 1
        reverse(nums, k, nums.length - 1); // -> 5, 6, 7, 1, 2, 3, 4
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] res = new int[]{1, 2};
        rotate(res, 3);
    }
}
