package arrays;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int[] count = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] ++;

        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) return i;
        }
        return 0;
    }

    ///second case
    /*
    public static int findDuplicate(int[] nums) {
        int[] count = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] ++;

            if (count[nums[i]] > 1) return nums[i];
        }

        return 0;
   }
    */

    public static void main(String[] args) {
        int[] n = new int[]{2,2};
        System.out.println(findDuplicate(n));
    }
}
