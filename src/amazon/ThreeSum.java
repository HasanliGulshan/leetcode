package amazon;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];

                if (val == 0) {
                    String check = nums[i] + " " + nums[j] + " " + nums[k];

                    if (!set.contains(check)) {
                        set.add(check);

                        List<Integer> triple = new ArrayList<>();

                        triple.add(nums[i]);
                        triple.add(nums[j]);
                        triple.add(nums[k]);

                        lists.add(triple);
                    }

                    j++;
                    k--;
                } else if (val < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        System.out.println(lists);
        return lists;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
