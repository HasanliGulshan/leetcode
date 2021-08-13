package arrays;

public class KLengthApart {
    public static boolean kLengthApart(int[] nums, int k) {
        int i = 0;

        while (i < nums.length && nums[i] == 0) {
            i++;
        }

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 1) {
                if ((j - i) <= k)
                    return false;

                i = j;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,0,0,1,0,1};
        System.out.println(kLengthApart(n, 2));
    }
}
