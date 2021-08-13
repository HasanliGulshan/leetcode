package hashMap;

import java.util.HashMap;
import java.util.Map;

public class FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        boolean value = false, key = false;

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {

            if (m.getValue() == 2) {
                ans[0] = m.getKey();
                value = true;
            }

            if (m.getKey() != 1 && !map.containsKey(m.getKey() - 1)) {
                ans[1] = m.getKey() - 1;
                key = true;
            }else if (!map.containsKey(m.getKey() + 1)) {
                ans[1] = m.getKey() + 1;
                key = true;
            }

            if (value && key) {
                System.out.println(ans[0] + " " + ans[1]);
                return ans;
            }

        }

        System.out.println(ans[0] + " " + ans[1]);
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new int[]{1, 1};
        System.out.println(findErrorNums(ans));
    }
}
