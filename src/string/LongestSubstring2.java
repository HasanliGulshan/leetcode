package string;

import java.util.HashSet;

public class LongestSubstring2 {
    public static int lengthOfLongestSubstring(String s) {
        int a = 0;
        int b = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while (b < s.length()) {
            if (!hashSet.contains(s.charAt(b))) {
                hashSet.add(s.charAt(b));
                max = Math.max(hashSet.size(), max);
                b++;
            } else {
                hashSet.remove(s.charAt(a));
                a++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
