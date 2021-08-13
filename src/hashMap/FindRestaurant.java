package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindRestaurant {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<>());

                    map.get(i + j).add(list2[j]);
                }
            }
        }

        for (int index : map.keySet()) {
            minIndex = Math.min(minIndex, index);
        }

        String[] ans = new String[map.get(minIndex).size()];

        return map.get(minIndex).toArray(ans);
    }
}
