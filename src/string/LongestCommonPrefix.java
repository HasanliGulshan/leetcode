package string;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            Arrays.sort(strs);

            for (String s : strs) {
                System.out.println(s);
            }

            int size = strs.length;
            int length = strs[0].length();
            StringBuilder res = new StringBuilder();

            for (int i=0; i < length; i++) {
                if (strs[0].charAt(i) == strs[size - 1].charAt(i)) {
                    res.append(strs[0].charAt(i));
                } /*else {
                    break;
                }*/
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] a = new String[n];

        for (int i=0; i<n; i++) {
            a[i] = s.next();
        }

        System.out.println(longestCommonPrefix(a));
    }

}
