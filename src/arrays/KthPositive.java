package arrays;

import java.util.HashMap;

public class KthPositive {
    public static int findKthPositive(int[] arr, int k) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int j = 1;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        while (k > 0) {

            if (map.containsKey(j)) {
                map.put(j, false);
            } else {
                k--;
            }

            j++;
        }
        return j - 1;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4};
        System.out.println(findKthPositive(n, 2));
    }
}
