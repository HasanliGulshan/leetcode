package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        final int sign = n1[0] == 45 ^ n2[0] == 45 ? -1 : 1;

        char[] result = new char[num1.length() + num2.length()];

        Arrays.fill(result, '0');

        for (int i = n1.length - 1; n1[0] == 45? i>0 : i>=0; i--) {
            int a = (n1[i] - '0');

            for (int j = n2.length - 1;  n2[0] == 45? j>0 : j>=0; j--) {

                int b = (n2[j] - '0');
                int mul = a*b;
                int res = (result[i+j+1] - '0') + mul;

                System.out.println("a: " + a + " b: " + b + " mul: " + mul + " res: " + res);

                result[i + j + 1] = (char) (res + '0');
                result[i + j] = (char)(((result[i+j] - '0') + res/10) + '0');
                result[i + j + 1] = (char) ((res % 10) + '0');
            }
        }

        int trailingZeros = 0;

        while (trailingZeros < result.length && result[trailingZeros] == '0') {
            trailingZeros++;
        }

        result = Arrays.copyOfRange(result, trailingZeros, result.length);

        if (result.length == 0) return "0";

        /*for (char c : result) {
            System.out.print(c);
        }
        System.out.println();*/
        return sign == -1 ? "-" + new String(result) : new String(result);
    }

   /* public static List<Integer> multiply(List<Integer> numl, List<Integer> num2) {
        final int sign = numl.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;

        numl.set(0, Math.abs(numl.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result
                = new ArrayList<>(Collections.nCopies(numl.size() + num2.size(), 0));
        for (int i = numl.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {

                result.set(i + j + 1, result.get(i + j + 1) + numl.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);

            }
        }
// Remove the leading zeroes.
        int first_not_zero = 0;
        while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        result = result.subList(first_not_zero, result.size());
        if (result.isEmpty()) {
            return Arrays.asList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }*/

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(8);
        /*System.out.println(multiply(l1, l2));*/

       /* String s = "-98";
        char[] c = s.toCharArray();
        System.out.println(c.length);
        for (char d : c) System.out.print(d + "  ");*/

       System.out.println(multiply("123", "48"));
    }

    ///third way
    /*
    StringBuilder res = new StringBuilder();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        final int sign = n1[0] == 45 ^ n2[0] == 45 ? -1 : 1;

        int[] result = sign == -1 ? new int[num1.length() + num2.length() -1] : new int[num1.length() + num2.length()];

        Arrays.fill(result, 0);

        for (int i = n1.length - 1; n1[0] == 45? i>0 : i>=0; i--) {
            int a = (n1[i] - '0');

            for (int j = n2.length - 1;  n2[0] == 45? j>0 : j>=0; j--) {

                int b = (n2[j] - '0');
                int mul = a*b;

                System.out.println("a: " + a + " b: " + b + " mul: " + mul + " res: " + res);

                result[i + j + 1] = result[i+j+1] + mul;
                result[i + j] = result[i+j] + result[i+j+1] / 10;
                result[i + j + 1] = result[i+j+1] % 10;
            }
        }

        int trailingZeros = 0;

        while (trailingZeros < result.length && result[trailingZeros] == 0) {
            trailingZeros++;
        }

        result = Arrays.copyOfRange(result, trailingZeros, result.length);

        if (result.length == 0) return "0";

        if (sign == -1) res.append(-1);

        for (int n : result) res.append(n);

        return res.toString();
     */
}
