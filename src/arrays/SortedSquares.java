package arrays;

public class SortedSquares {

    public static int[] sortedSquares(int[] nums) {
        int start = 0, end = nums.length - 1, len = nums.length - 1;
        int[] res = new int[nums.length];

        while (start < end) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[len--] = (int)Math.pow(nums[start], 2);
                start++;
            } else {
                res[len--] = (int)Math.pow(nums[end], 2);
                end--;
            }
        }

        res[len] = nums[start] * nums[start];

        for (int a : res) System.out.print(a + " ");
        return res;
    }

    public static void main(String[] args) {
        int[] n = new int[]{-4,0,1,1};

        System.out.println(sortedSquares(n));
    }
}
