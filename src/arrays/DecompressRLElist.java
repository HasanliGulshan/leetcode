package arrays;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLElist {

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int h = 0;

        for (int i = 0; i < nums.length; i+=2) {
            int freq = nums[i];

            while (freq -- >0) {
                list.add(nums[i+1]);
            }
        }

        System.out.println(list);
        int[] ans = new int[list.size()];

        for (int l : list)
            ans[h++] = l;

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,1,2,3};

        System.out.println(decompressRLElist(n));
    }
}
