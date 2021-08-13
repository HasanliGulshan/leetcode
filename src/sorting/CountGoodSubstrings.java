package sorting;

import java.util.HashSet;

public class CountGoodSubstrings {
    public static int countGoodSubstrings(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 3 <= s.length()) {

                String sub = s.substring(i, i + 3);
                set.clear();

                for (int j = 0; j < sub.length(); j++) {
                    set.add(sub.charAt(j));
                }

                if (set.size() == 3) ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
