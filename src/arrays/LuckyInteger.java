package arrays;

public class LuckyInteger {
    public static int findLucky(int[] arr) {
        int[] count = new int[501];
        int ans = -1;

        for (int i = 0; i<arr.length; i++)
            count[arr[i]]++;

        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i]] == arr[i]) {
                ans = Math.max(ans, arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{5};
        System.out.println(findLucky(n));
    }
}
