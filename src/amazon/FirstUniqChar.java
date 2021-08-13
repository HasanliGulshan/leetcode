package amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public static char firstUniqChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int firstIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                firstIndex = Math.min(firstIndex, str.indexOf(m.getKey()));
            }
        }

        return str.charAt(firstIndex);
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabccd"));
    }
}
