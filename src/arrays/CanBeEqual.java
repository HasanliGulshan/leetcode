package arrays;

import java.util.Arrays;

public class CanBeEqual {

    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort((arr));

        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
       int[] target = new int[]{1,2,3}, arr = new int[]{2,4,1};

        System.out.println(canBeEqual(target, arr));
    }
}
