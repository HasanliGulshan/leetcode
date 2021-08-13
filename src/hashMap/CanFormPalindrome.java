package hashMap;

import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome {
    ///time complexity O(n) and space complexity O(c) where c is distinct chars in te string
    public static boolean canFormPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        // A string can be permuted as a palindrome if and only if the number of
        // chars whose frequencies is odd is at most 1.
        int oddCount = 0;
        for (Map.Entry<Character, Integer> p : map.entrySet()) {
            if ((p.getValue() % 2) != 0 && ++oddCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("edified"));
    }
}
