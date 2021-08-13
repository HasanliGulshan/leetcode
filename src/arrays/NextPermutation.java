package arrays;

import java.util.Collections;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int len = nums.length - 2;

        while (len >= 0 && nums[len] >= nums[len + 1]) {
            len--;
        }

        if (len != -1) {

            for (int i = nums.length - 1; i > len; i--) {
                if (nums[i] > nums[len]) {
                    int temp = nums[i];
                    nums[i] = nums[len];
                    nums[len] = temp;
                    break;
                }
            }
        }

        System.out.println("len = " + len);
        len += 1;
        int len2 = nums.length - 1;

        while (len2 > len) {
            int temp = nums[len];
            nums[len] = nums[len2];
            nums[len2] = temp;

            len2--;
            len++;
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] n = new int[]{3, 2, 1};
        int[] n2 = new int[]{6, 2, 1, 5, 4, 3, 0};

        nextPermutation(n);
        nextPermutation(n2);
    }
}
