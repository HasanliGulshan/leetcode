package hashMap;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {
    public static int repeatedNTimes(int[] A) {
        int times = A.length / 2, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            ans = m.getKey();
            if (m.getValue() == times) {
                break;
            }
        }

        return ans;
    }
}
