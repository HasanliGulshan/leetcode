package arrays;

import java.util.HashMap;

public class CountPairs {
    public static int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int mod = 1000000007;

        for (int delicious : deliciousness) {
            int p = 1;
            for (int i = 0; i<=21; i++) {
                if (map.containsKey(p - delicious)) {
                    res += map.get(p - delicious);
                    res %= mod;
                }
                p = p << 1;
            }
            map.put(delicious, map.getOrDefault(delicious, 0) + 1);
        }

        return res%mod;
    }
    public static void main(String[] args) {
        int[] n = new int[]{1,3,5,7,9};
        System.out.println(countPairs(n));
    }
}
