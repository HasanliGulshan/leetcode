package hashMap;

import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> mapChar = new HashMap<>();
        HashMap<String, Character> mapWord = new HashMap<>();

        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!mapChar.containsKey(c)) {
                if (mapWord.containsKey(w)) {
                    return false;
                } else {
                    mapChar.put(c, w);
                    mapWord.put(w, c);
                }

            } else {
                String mapped_word = mapChar.get(c);
                if (!mapped_word.equals(w))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abab", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
