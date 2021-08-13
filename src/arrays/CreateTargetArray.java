package arrays;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] ans = new int[list.size()];

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        for (int h : ans) System.out.print(h + " ");
        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4,0};
        int[] index = new int[]{0,1,2,3,0};

        System.out.println(createTargetArray(n, index));
    }
}
