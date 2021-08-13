package arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int countOfZeros = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[countOfZeros++] = nums[i];
            }
        }

        for (int i = countOfZeros,h = 0; i < nums.length; i++, h++) {
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        moveZeroes(nums);
    }
}
