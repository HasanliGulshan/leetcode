package arrays;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int ans = 0;
        int[] copied = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copied[i])
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4,5};
        System.out.println(heightChecker(n));
    }
}
