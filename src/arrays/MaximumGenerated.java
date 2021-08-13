package arrays;

import java.util.Arrays;

public class MaximumGenerated {
    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;

        for (int i = 1; i < n; i++) {

            if (2 * i <= n) res[2 * i] = res[i];

            if (2 * i + 1 <= n) res[2 * i + 1] = res[i] + res[i+1];
        }

        Arrays.sort(res);

        return res[res.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(1));
    }
}
