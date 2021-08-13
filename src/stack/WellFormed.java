package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class WellFormed {
    //t c O(n)
    public static boolean isWellFormed(String s){
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.addFirst(c);
            } else {
                //unmatched right char
                if (deque.isEmpty()) return false;

                if ((c == ')' && deque.peekFirst() != '(')
                        || (c == '}' && deque.peekFirst() != '{')
                        || (c == ']' && deque.peekFirst() != '['))
                    return false;

                deque.removeFirst();
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isWellFormed("([)]"));
    }
}
