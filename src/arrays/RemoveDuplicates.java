package arrays;

import java.util.Scanner;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            int size = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    nums[size++] = nums[i];
                }
            }
            nums[size] = nums[nums.length - 1];
            return size + 1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println("n = " + n);
        int[] nums = new int[n];
        for (int i = 0; i< n; i++) {
            nums[i] = s.nextInt();
        }
       int size = removeDuplicates(nums);
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
