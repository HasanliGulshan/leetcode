package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWords {
    public static String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        getMapByLevel(map, "qwertyuiop", 1);
        getMapByLevel(map, "asdfghjkl", 2);
        getMapByLevel(map, "zxcvbnm", 3);
        List<String> list = new ArrayList<>();

        for (String word : words) {
            int level = map.get(Character.toLowerCase(word.charAt(0)));
            boolean flag = true;

            for (int i = 1; i < word.length(); i++) {
                if (flag && map.get(Character.toLowerCase(word.charAt(i))) != level) {
                    flag = false;
                }
            }

            if (flag) {
                list.add(word);
            }
        }

        System.out.println(list);
        String[] res = new String[list.size()];

        return list.toArray(res);
    }

    public static void getMapByLevel(HashMap<Character, Integer> map, String curr, int level) {
        for (int i = 0; i < curr.length(); i++) {
            map.put(curr.charAt(i), level);
        }
    }

    public static void main(String[] args) {
        String[] res = new String[]{"omk"};

        findWords(res);
    }
}
