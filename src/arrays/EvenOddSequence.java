package arrays;

public class EvenOddSequence {
    public static int makeEvenOddSequence(int[] nums) {
        if (nums == null || nums.length == 1) return 0;

        int count = 0, i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] %2 != 0 && nums[j] %2  == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                count++;
            }

            if (nums[i] %2 == 0) {
                i++;
            }

            if (nums[j] % 2 != 0) {
                j--;
            }
        }

        for (int a : nums) {
            System.out.print(a + " ");
        }
        System.out.println("count: " );
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 6, 9, 15, 78, 64, 22, 7};

        System.out.println(makeEvenOddSequence(nums));
    }
}
