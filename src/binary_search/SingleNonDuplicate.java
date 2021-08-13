package binary_search;

public class SingleNonDuplicate {
    public static int singleNonDuplicate(int[] nums) {
        /*int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;

            if ((mid == 0 && nums[mid] != nums[mid + 1]) ||
                    (mid == nums.length - 1 && nums[mid - 2] != nums[mid]) || (mid > 0 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }


        }*/

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
