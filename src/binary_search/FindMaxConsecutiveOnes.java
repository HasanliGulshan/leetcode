package binary_search;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnesFirst(int[] nums) {
        int max = 0, counter = 0;

        for (int num : nums) {
            if (num == 0) {
                counter = 0;
            } else {
                counter++;
                max = Math.max(max, counter);
            }
        }

        return max;
    }

    public static int longestOnesThird(int[] nums, int k) {
        int maxLen = 0, counter = 0, r = 0, l = 0, n = nums.length;

        while (r < n) {
            if (nums[r] == 0) {
                counter++;
            }

            while (counter > k) {
                if (nums[l] == 0) {
                    counter--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnesThird(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
