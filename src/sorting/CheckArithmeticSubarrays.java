package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];

            int[] temp = new int[end - start + 1];
            int index = 0;

            while (start <= end) {
                temp[index++] = nums[start++];
            }

            Arrays.sort(temp);

            boolean isArithmetic = true;
            int diff = temp[1] - temp[0];

            for (int j = 1; j < temp.length; j++) {
                if (diff != temp[j] - temp[j - 1]) {
                    isArithmetic = false;
                    break;
                }
            }

            ans.add(isArithmetic);
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0, 1, 6, 4, 8, 7}, new int[]{1, 4, 9, 7, 9, 10});
    }
}
