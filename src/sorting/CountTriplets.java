package sorting;

public class CountTriplets {
    public static int countTriplets(int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                value ^= arr[j];

                if (value == 0) {
                    ans += j - i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,6,7};

        System.out.println(countTriplets(arr));
    }
}
