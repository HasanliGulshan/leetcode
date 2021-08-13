package sorting;

import java.util.HashMap;

public class MinSteps {
    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;

        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;

                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }

            } else {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //""
        //""
        System.out.println(minSteps("leetcode",
                "practice"));
    }
}
