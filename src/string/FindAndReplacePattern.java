package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
         List<String> ans = new ArrayList<>();

         for (String word : words) {
             if (isPattern(pattern, word))
                 ans.add(word);
         }

         System.out.println(ans);
         return ans;
    }

    static boolean isPattern (String pattern, String word) {
        if (pattern.length() != word.length()) return false;

        HashMap<Character, Character> pMap = new HashMap<>();
        HashMap<Character, Character> wMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char c = word.charAt(i);

            if (!pMap.containsKey(p)) {
                if (wMap.containsKey(c)) {
                    return false;
                } else {
                    pMap.put(p, c);
                    wMap.put(c, p);
                }
            } else {
                char pValue = pMap.get(p);

                if (pValue != word.charAt(i)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        System.out.println(findAndReplacePattern(words, pattern));
    }
}
