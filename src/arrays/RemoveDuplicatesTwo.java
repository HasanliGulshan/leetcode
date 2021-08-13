package arrays;


public class RemoveDuplicatesTwo {
    /*public static int removeDuplicates(int[] nums) {
        int count = 0, size = 0, i = 0;

        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                continue;
            }
            if (count >= 1) {
                nums[size++] = nums[i];
                nums[size++] = nums[i];
            } else {
                nums[size++] = nums[i];
            }
            count = 0;
        }

        if (count >= 1) {
            nums[size++] = nums[i];
            nums[size++] = nums[i];
        } else {
            nums[size++] = nums[i];
        }

        nums[size] = nums[nums.length - 1];
        for (int h = 0; h < size; h++) System.out.print(nums[h] + " ");

        System.out.println();
        return size;
    }*/
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;

        /*
         * This index will move when we modify the array in-place to include an element
         * so that it is not repeated more than twice.
         */
        int j = 0;

        for (int i = 0; i < n; i++) {
            /*
             * If the current element is equal to the element at index i+2, then skip the
             * current element because it is repeated more than twice.
             */
            //i < n-2 make if condition wrong for last element which is not unique and nums[j++] execute
            if (i < n - 2 && nums[i] == nums[i + 2]) {
                continue;
            }

            nums[j++] = nums[i];
        }

        return j;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1, 1, 1, 1, 2, 3, 3, 3};
      //  int[] k = new int[]{1, 1, 1, 2, 3, 3};
        int newLength = removeDuplicates(n);

        System.out.println("Length of array after removing duplicates = " + newLength);

        System.out.print("Array = ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }
}
