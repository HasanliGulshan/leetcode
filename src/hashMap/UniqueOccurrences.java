package hashMap;

import java.util.*;

public class UniqueOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);

        HashSet<Integer> set = new HashSet<>();

        for (int i : map.values()) {
            //if set is already has i, will return false, if not will add i
            if (!set.add(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] n = new int[]{26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
        System.out.println(uniqueOccurrences(n));
    }
}
