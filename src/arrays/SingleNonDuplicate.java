package arrays;

public class SingleNonDuplicate {
    public static int singleNonDuplicate(int[] nums) {
        //corner cases
        if (nums.length == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];

        int right = nums.length - 1;
        if (nums[right - 1] != nums[right]) return nums[right];

        int left = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (mid %2 != 0 && nums[mid - 1] == nums[mid]) {
                left = mid + 1;
            } else if (mid % 2 != 0 && nums[mid] == nums[mid + 1]) {
                right = mid - 1;
            } else if (mid % 2 == 0 && nums[mid] == nums[mid - 1]){
                right = mid - 2;
            } else if (mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                left = mid + 2;
            } else {
                return nums[mid];
            }
        }

        return -1;
    }
}
