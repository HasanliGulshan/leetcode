package bits;

import java.util.Arrays;

public class SingleNumberTwo {
    /* [2, 2, 2, 3] == [010, 010, 010, 011]
    sum number bits = [0, 4, 1] every number occurs 3 times and just one number occurs 1 time so taking module 3 will give remaining bits which belong to our answer
    [0 % 3, 4%3, 1%3] = [0, 1, 1] = 3
    a^b = those bit positions are set that have different values in a from b
    * */

    //using only positive number
    /*public static int singleNumber(int[] nums) {
        //int is 32 bits
        int[] count = new int[32];
        int res = 0, power = 1;

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int num = nums[i];
            while (num > 0) {
                if ((num & 1) != 0) {
                    count[j]++;
                }
                num>>=1;
                j++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            //get unique number bits by getting module
            count[i] %= 3;
            res += count[i] * power;
            power <<= 1;
        }

        return res;
    }*/

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums); //O(n * log(n))

        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];

        if (nums[nums.length - 2] != nums[nums.length - 1]) return nums[nums.length - 1];

        for (int i = 1; i < nums.length; ) {
            if (nums[i] == nums[i - 1]) {
                i+=3;
            } else {
                return nums[i-1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
      //  int[] n = new int[]{-2,-2,1,1,4,1,4,4,-4,-2};
      //  int[] n = new int[]{2,2,3,2};
        int[] n = new int[]{0};
        System.out.println(singleNumber(n));
    }
}
