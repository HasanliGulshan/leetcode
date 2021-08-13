package hashMap;

import java.util.ArrayList;
import java.util.List;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1000];
        int[] count2 = new int[1000];
        List<Integer> list = new ArrayList<>();

        for (int n : nums1) count1[n]++;

        for (int n : nums2) count2[n]++;

        for (int n : nums1) {
            if (count1[n] > 0 && count2[n] > 0) {
                int times = Math.min(count1[n], count2[n]);

                while (times > 0) {
                    list.add(n);
                    times--;
                }
                count1[n] = 0;
                count2[n] = 0;
            }
        }

        System.out.println(list);
        int[] ans = new int[list.size()];
        int i = 0;

        for (int item : list)
            ans[i++] = item;

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2, 2};

        System.out.println(intersect(nums1, nums2));
    }
}
