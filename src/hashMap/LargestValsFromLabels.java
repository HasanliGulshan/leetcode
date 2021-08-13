package hashMap;

import java.util.HashMap;
import java.util.Map;

public class LargestValsFromLabels {
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : values) {
            for (int label : labels) {
                if (value <= num_wanted && label <= use_limit) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }
            }
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            ans += m.getValue() * m.getKey();
        }

        return ans;
    }

    public static void main(String[] args) {
        //values = [], labels = [], num_wanted = 3, use_limit = 1
        int[] n = new int[] {5,4,3,2,1};
        int[] m = new int[] {1,1,2,2,3};

        System.out.println(largestValsFromLabels(n, m,3, 1));
    }
}
