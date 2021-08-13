package hashMap;

import java.util.HashMap;

public class Happy {
    public static boolean isHappy(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (true) {

            if (n == 1) return true;

            map.put(n, true);

            n = getDigitsSum(n);

            if (map.containsKey(n)) return false;

            map.put(n, true);
        }
    }

    public static int getDigitsSum(int n) {
        int digitSum = 0;

        while (n > 0) {
            digitSum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return digitSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
