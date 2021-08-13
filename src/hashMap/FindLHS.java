package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindLHS {
   /* public static int findLHS(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxSub = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());

        for (int j = 0; j < keys.size() - 1; j++) {
            if (Math.abs(keys.get(j + 1) - keys.get(j)) == 1) {
                List<Integer> item1 = map.get(keys.get(j));
                List<Integer> item2 = map.get(keys.get(j + 1));

                if (item1.get(0) < item2.get(0) || (item1.get(0) > item2.get(0))) {
                    int size1 = item1.size();
                    int size2 = item2.size();
                    if (item1.get(size1 - 1) < item2.get(size2 - 1) || (item1.get(size1 - 1) > item2.get(size2 - 1))) {
                        maxSub = Math.max(maxSub, size1 + size2);
                    }
                }

            }
        }
        return maxSub;
    }*/

    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSub = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                maxSub = Math.max(maxSub, map.get(key) + map.get(key + 1));
        }

        return maxSub;
    }

    public static void main(String[] args) {
        int[] n = new int[]{0, 3, 1, 3, 3, 3, 0, 1, 0, 2, 0, 3, 1, 3, -3, 2, 0, 3, 1, 2, 2, -3, 2, 2, 3, 3};
        // int[] n = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(findLHS(n));
    }
}
