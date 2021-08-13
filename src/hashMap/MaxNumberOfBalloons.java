package hashMap;

import java.util.HashMap;

public class MaxNumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: text.toCharArray())
            map.put(c, map.getOrDefault(c, 0)  +1);

        if (map.get('b') == null || map.get('a') == null || map.get('l') == null || map.get('o') == null ||  map.get('n') == null)
            return 0;

        int min = Math.min(map.get('b'), map.get('a'));
        min = Math.min(min,  map.get('l') / 2);
        min = Math.min(min, map.get('o') / 2);

        return Math.min(min, map.get('n'));
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text));
    }
}
