package arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0, i = 0;

        while (i < nums.length) {
            start = i;

            while (i < nums.length && i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (nums[start] == nums[i]) {
                ans.add("" + nums[start] + "");
            } else {
                ans.add("" + nums[start] + "->" + nums[i] + "");
            }

            i += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(summaryRanges(nums));
    }
}
