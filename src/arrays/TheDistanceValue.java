package arrays;

public class TheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0, count = 0;

        for (int i = 0; i<arr1.length; i++) {
            count = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr2[j] - arr1[i]) > d) {
                    count++;
                }
            }
            if (count == arr2.length) ans++;
        }

        return ans;
    }

}
