package arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int smaller = 0;
        int equal = 0;
        int larger = nums.length-1;
        int temp;

        while (equal <= larger) {
            switch (nums[equal]) {
                case 0:
                    temp = nums[equal];
                    nums[equal++] = nums[smaller];
                    nums[smaller++] = temp;
                    break;
                case 1:
                    equal++;
                    break;
                case 2:
                    temp = nums[equal];
                    nums[equal] = nums[larger];
                    nums[larger--] = temp;
                    break;
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        int[] n2 = new int[]{1,2,0};
        sortColors(n2);
    }
}
