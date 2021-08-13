package stack;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses {
    public static int scoreOfParentheses(String S) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                deque.addFirst(0);
            } else {
                int v = deque.pop();
                int w = deque.pop();
                deque.addFirst(w + Math.max(2 * v, 1));
            }
        }

        return deque.pop();
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
