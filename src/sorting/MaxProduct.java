package sorting;

public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int j = nums.length - 1, i = 0;
         int ans = 0;

         while (i <= j) {

             if (i != j) {
                 int val = nums[i] - 1;
                 int val2 = nums[j] - 1;

                 ans = Math.max(ans, val * val2);
             }

             if (nums[i] <= nums[j]) {
                 i++;
             } else {
                 j--;
             }
         }

         return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
    }
}
