package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public static int countLargestGroup(int n) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int max = Integer.MIN_VALUE, ans = 0;

       for (int i = 1; i <= n; i++) {
           int sum = sumDigits(i);
           map.put(sum, map.getOrDefault(sum, 0) + 1);
       }

       for (Map.Entry<Integer, Integer> m : map.entrySet()) {
           int value = m.getValue();
           if (max < value) max = value;
       }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == max) ans++;
        }

        return ans;
    }

    static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(15));
    }
}
