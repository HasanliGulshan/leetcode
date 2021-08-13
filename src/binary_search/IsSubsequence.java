package binary_search;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        Deque<Character> deque = new ArrayDeque<>();
        int index = 0;

        for (char c : t.toCharArray()) {
            deque.addLast(c);

            char r = deque.removeFirst();
            if (index < s.length() && r == s.charAt(index)) {
                index++;
            }
        }

        return index == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
