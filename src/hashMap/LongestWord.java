package hashMap;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        String ans = "";

        HashSet<String> set = new HashSet<>();

        for (String word: words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);

                if (word.length() > ans.length()) ans = word;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
       String[] words = new String[]{"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words));
    }
}
