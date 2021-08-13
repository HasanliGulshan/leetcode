package arrays;


import java.util.Map;

public class CountGoodTriplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {

                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;

                for (int k = j + 1; k < arr.length && i != k; k++) {

                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3, 0, 1, 1, 9, 7};

        System.out.println(countGoodTriplets(n, 7, 2, 3));
    }
}
