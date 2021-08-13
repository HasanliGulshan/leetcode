package bits;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        if (nums[0] != 0) return 0;

        if (nums[len - 1] != len) return len;

        for (int i = 1; i<len; i++) {
            if (nums[i] != nums[i - 1] +1){
                return nums[i - 1] +1;
            }
        }
return -1;
    }

    public static void main(String[] args) {

    }
}
