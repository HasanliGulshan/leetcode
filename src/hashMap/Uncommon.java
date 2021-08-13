package hashMap;

import java.util.HashMap;
import java.util.Map;

public class Uncommon {
    public String[] uncommonFromSentences(String A, String B) {
        String[] words1 = A.split(" ");
        String[] words2 = B.split(" ");
        int count = 0, j = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words1) map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : words2) map.put(s, map.getOrDefault(s, 0) + 1);

        for (Integer i : map.values()) {
            if (i == 1)
                count++;
        }

        String[] ans = new String[count];

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 1)
                ans[j++] = m.getKey();
        }

        return ans;
    }
}
