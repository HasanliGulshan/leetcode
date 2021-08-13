package hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UsersActiveMinutes {
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Arrays.fill(ans, 0);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            if (!map.containsKey(logs[i][0]))
                map.put(logs[i][0], new HashSet<>());

            map.get(logs[i][0]).add(logs[i][1]);
        }

        HashMap<Integer, Integer> ansMap = new HashMap<>();

        for (Map.Entry<Integer, HashSet<Integer>> m : map.entrySet()) {
            if (!ansMap.containsKey(m.getValue().size())) {
                ansMap.put(m.getValue().size(), ansMap.getOrDefault(m.getValue().size(), 0) + 1);
            } else {
                ansMap.put(m.getValue().size(),  ansMap.get(m.getValue().size()) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : ansMap.entrySet()) {
            ans[m.getKey() - 1] = m.getValue();
        }

        for (int a : ans) System.out.print(a + " ");

        return ans;
    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{{1,1},{2,2},{2,3}};
        int k = 4;

        System.out.println(findingUsersActiveMinutes(logs, k));
    }
}
