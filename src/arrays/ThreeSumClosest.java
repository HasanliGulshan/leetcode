package arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        //sort num, bcs using two pointer pattern here
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum ;
        int x = 5;
        System.out.println(Math.abs(x) );
        x *=-1;
        System.out.println(Math.abs(x));

        for (int i = 0; i < nums.length && diff !=0; i++) {
            //start left by i + 1
            int left = i + 1;
            //start from end of arr
            int right = nums.length - 1;

            while (left < right) {
                 // sum three nums from arr including nums[i]
                 sum = nums[i] + nums[left] + nums[right];
                 //here sum can change that is why we return target - diff : diff chane only condition satisfied and target is constant

                 //if their abs diff (|2-1|) is less than diff, update diff
                 if (Math.abs(target - sum) < Math.abs(diff)) {
                     diff = target - sum;
                 }

                 //if sum is less than target than increase left, bcs sorted array has less value before
                 if (sum < target) {
                     left++;
                 } else {
                    //else decrease right bcs arr has big values going to the end
                     right--;
                 }
            }
        }

        return target - diff;
    }

    public static void main(String[] args) {
        int[] num = new int[] {-1, 2, 1, -4};
        System.out.println(threeSumClosest(num, 1));
    }
}
