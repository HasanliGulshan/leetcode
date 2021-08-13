package bits;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    /*public static char findTheDifference(String s, String t) {
         if (s.length() == t.length()) return ' ';

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (value == 1) return key;
        }
        return ' ';
    }*/

    public static char findTheDifference(String s, String t) {
        char c = '\0';
        String s1 = s + t;

        for (char a : s1.toCharArray())
            c ^= a;

        return c;
    }
    public static void main(String[] args) {
        System.out.println(findTheDifference("", "y"));
    }
}
