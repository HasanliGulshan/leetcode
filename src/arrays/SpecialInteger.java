package arrays;

public class SpecialInteger {
    public static int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];

        int count = 0, i = 0;
        double out = 0;

        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
                continue;
            }
            out = count * 100 / arr.length;
            if (out > 25) return arr[i];

            count = 0;
        }

        if (count != 0) {
            out = count * 100 / arr.length;
            if (out >= 25) return arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n = new int[]{1,2, 3, 3};
        System.out.println(findSpecialInteger(n));
    }
}
