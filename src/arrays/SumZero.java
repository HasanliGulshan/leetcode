package arrays;

public class SumZero {

    public static int[] sumZero(int n) {
        int[] nums = new int[n];
        int index = 0;

        n -= 1;
        for (int i = 0, h = 1; i < nums.length / 2; i++, h++) {
            nums[index] = h;
            nums[n--] = -1 * nums[index];

            index++;
        }

        for (int m : nums) System.out.print(m + " ");

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(sumZero(6));
    }
}
