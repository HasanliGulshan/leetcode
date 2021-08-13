package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        map.put(strs[0], list);

        for (int i = 1; i < strs.length; i++) {
            boolean isPairAnagram = false;

            for (String s : map.keySet()) {
                if (s.equals(strs[i]) || (!s.isEmpty() && isAnagram(s, strs[i]) && s.length() == strs[i].length())) {
                    map.get(s).add(strs[i]);
                    isPairAnagram = true;
                    break;
                }
            }

            if (!isPairAnagram) {
                List<String> newAnagramList = new ArrayList<>();
                newAnagramList.add(strs[i]);
                map.put(strs[i], newAnagramList);
            }
        }

        List<List<String>> ans = new ArrayList<>(map.values());

        System.out.println(ans);

        return ans;
    }

    static boolean isAnagram(String s1, String s2) {
        int[] count = new int[256];
        int i;

        for (i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (i = 0; i < 256; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"", "", "eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};

        groupAnagrams(s);
    }
}
