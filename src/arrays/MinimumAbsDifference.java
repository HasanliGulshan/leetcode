package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i] - arr[i - 1];
            if (value < min)
                min = value;
        }

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i] - arr[i - 1];

            if (value == min) {
                item = new ArrayList<>();
                item.add(arr[i - 1]);
                item.add(arr[i]);

                ans.add(item);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3,8,-10,23,19,-4,-14,27};

        System.out.println(minimumAbsDifference(n));
    }
}
