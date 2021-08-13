package arrays;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOneTwo {
    /*public static List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);

            if (A.get(0) == 10) {
            // Need additional digit as the most significant digit ( i.e A. get (9))
                // has a carry-out .
                A.set(0, 0);
                A.add(0, 1);
            }

        } return A;
    }*/


    public static int[] plusOne(int[] digits) {
        int[] plusOneArr = new int[digits.length + 1];
        int len = digits.length - 1;
        digits[len] = digits[len] + 1;
        plusOneArr[len] = digits[len] + 1;

        for (int i = len; i >= 0 && digits[i] == 10; i--) {

            if (digits[0] == 10) {
                plusOneArr[1] = 0;
                plusOneArr[0] = 1;

                return plusOneArr;
            }

            digits[i] = 0;
            plusOneArr[i] = 0;

            if (i > 0) {
                digits[i - 1] = digits[i - 1] + 1;
                plusOneArr[i - 1] = digits[i - 1] + 1;
            }

        }
        return digits;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);

        //  System.out.println(plusOne(list));

        int[] p = new int[]{99};
        int[] k = new int[4];
        k = plusOne(p);
        for (int i : k) {
            System.out.print(i + " ");
        }
    }

}
