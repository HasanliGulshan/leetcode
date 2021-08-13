package arrays;

import java.util.Scanner;

public class RemoveElement2 {
    public static int removeElement(int[] nums, int val) {
        int size = 0;
        for (int n : nums)
            if (n != val)  {
                System.out.println("n = " + n + " val " + val);
                nums[size++] = n;
            }

        return size;
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

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
