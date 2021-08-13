package string;

import java.util.Arrays;

public class CheckInclusionPermutation {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];

        int k = s1.length(), i = 0;

        while (i < k) {
            s1Hash[s1.charAt(i) - 'a']++;
            s2Hash[s2.charAt(i) - 'a']++;

            i++;
        }

        i -= 1;
        while (i < s2.length()) {

            //checking equality of values in array
            if (Arrays.equals(s1Hash, s2Hash)) return true;

            i += 1;

            if (i != s2.length())
                //add
                s2Hash[s2.charAt(i) - 'a']++;
            //subtract
            s2Hash[s2.charAt(i - k) - 'a']--;
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";

        System.out.println(checkInclusion(s1, s2));
    }
}
