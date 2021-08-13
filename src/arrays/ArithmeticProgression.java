package arrays;

import java.util.Arrays;

public class ArithmeticProgression {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 1) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (diff != arr[i] - arr[i - 1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] n = new int[] {1, 2, 4};
        System.out.println(canMakeArithmeticProgression(n));
    }
}
