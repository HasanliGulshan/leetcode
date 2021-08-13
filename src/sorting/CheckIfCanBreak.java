package sorting;

import java.util.Arrays;
import java.util.Collections;

public class CheckIfCanBreak {
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        int check1 = 0, check2 = 0;

        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] <= s2Arr[i]) {
                check1++;
            }

            if (s1Arr[i] >= s2Arr[i]) {
                check2++;
            }
        }

        return check1 == s1Arr.length || check2 == s2Arr.length;
    }

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("leetcodee", "interview"));
    }
}
