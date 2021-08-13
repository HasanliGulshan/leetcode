package arrays;

import java.util.stream.IntStream;

public class SumOddLengthSubarrays {
    public static int sumOddLengthSubarrays(int[] arr) {

        return IntStream.range(0, arr.length).map(i -> (((i + 1)* (arr.length - i)+ 1)/ 2)* arr[i]).sum();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(a));
    }
}
