package hashMap;

import java.util.HashMap;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        int index = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i= 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;


        }

        return index;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
