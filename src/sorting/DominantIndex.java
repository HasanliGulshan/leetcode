package sorting;

public class DominantIndex {
    public static int dominantIndex(int[] nums) {
        int maxIdx = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }

        for (int n : nums) {
            if (n != max && max < 2 * n) {
                return -1;
            }
        }

        return maxIdx;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[] {1}));
    }
}
