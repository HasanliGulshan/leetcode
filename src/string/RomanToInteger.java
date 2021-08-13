package string;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = s.length() - 1; i >= 0; i--) {
            if ((i == 0) || (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1)))) {
                ans += map.get(s.charAt(i)); // XII
            } else if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))){
                ans += map.get(s.charAt(i)) - map.get(s.charAt(i - 1)); //IV
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IC"));
    }
}
