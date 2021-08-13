package arrays;

import java.util.Scanner;

public class RemoveElement {
        public static int removeElement(int[] nums, int val) {
            System.out.println("here we are");
            int right = nums.length - 1;
            int left = 0;
            int temp;
            int count = 0;

            while (left <= right) {
                if (nums[left] == val && nums[right] != val) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                } else if (nums[right] == val) {
                    right--;
                } else if (nums[left] != val) {
                    left++;
                }
            }

            for (int i=0; i<nums.length; i++) {
                if (nums[i] != val) {
                    count++;
                } else {
                    break;
                }
            }
         return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println("n = " + n);
        int[] nums = new int[n];
        for (int i = 0; i< n; i++) {
            nums[i] = s.nextInt();
        }
        System.out.println("val????");
        int val = s.nextInt();

        System.out.println(removeElement(nums, val));

        for (int i = 0; i< nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
