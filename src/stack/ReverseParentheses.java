package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseParentheses {
    public static String reverseParentheses(String s) {
        char[] ans = new char[s.length()];
        Deque<Integer> indexParentheses = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexParentheses.addFirst(i);
            } else if (!indexParentheses.isEmpty() && s.charAt(indexParentheses.peekFirst()) == '(' && s.charAt(i) == ')') {
                reverseByIndex(indexParentheses.pop() + 1, i - 1, ans);
            } else {
                ans[i] = s.charAt(i);
            }
        }

        for (char c : ans) {
            if (c != '\0')
                sb.append(c);
        }

        return sb.toString();
    }

    static void reverseByIndex(int start, int end, char[] ans) {
        while (start < end) {
            char temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("appleappleappleappleappleapple".length());
    }
}
