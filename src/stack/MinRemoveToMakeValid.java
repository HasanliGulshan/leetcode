package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinRemoveToMakeValid {
    public static String minRemoveToMakeValid(String s) {
        char[] ansChar = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addFirst(i);
            } else if (!deque.isEmpty() && s.charAt(i) == ')') {
                // ( (()) last 4 will be inserted with right index in deque, for first ( will not be right condition ),
                // (())))))  deque will be empty so only first 4 will be inserted
                //only valid parentheses will be inserted into ansChar
                char c = s.charAt(deque.peekFirst());

                if (c == '(') {
                    System.out.println(deque.peekFirst());
                    ansChar[deque.pop()] = '(';
                    ansChar[i] = s.charAt(i);
                }
            } else if (s.charAt(i) != ')') {
                ansChar[i] = s.charAt(i);
            }
        }

        for (char a : ansChar) {
            if (a != '\0')
                sb.append(a);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(ab(c)d)"));
    }
}
