package string;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) return false;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss, tt);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
