package arrays;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        } else {
            int len = digits.length;
            int h = digits[len - 1] + 1;
            digits[len - 1] = h % 10;
            boolean cover = h >= 10;
            h /= 10;
            System.out.println("h = " + h);

            if (cover) {
                System.out.println("c" + cover);

                for (int i = len - 2; i >= 0; i--) {
                    h += digits[i];
                    System.out.println("in loop h = " + h);
                    if (h >= 10) {
                        digits[i] = h % 10;
                        h = h / 10;
                    } else {
                        digits[i] = h % 10;
                        h = 0;
                    }
                }

                if (h == 1) {
                    int[] digits2 = new int[digits.length + 1];
                    digits2[0] = h;

                    for (int i=0, j = 1; i < digits.length; i++, j++) {
                        digits2[j] = digits[i];
                    }

                    for (int i = 0; i < digits2.length; i++) {
                        System.out.print(digits2[i] + " ");
                    }

                    return digits2;
                }
                System.out.println("h = " + h);
            }

            for (int i = 0; i < digits.length; i++) {
                System.out.print(digits[i] + " ");
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[] {1, 2, 3, 4};
        plusOne(digits);

    }
}
