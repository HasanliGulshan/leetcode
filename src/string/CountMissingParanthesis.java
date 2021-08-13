package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountMissingParanthesis {
    public static int countMissingParanthesis(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addFirst(c);
            } else {
                if (!deque.isEmpty() && c == ')' && deque.peekFirst() == '(') {
                    deque.removeFirst();
                } else {
                    count++;
                }
            }
        }

        System.out.println("deque size : " + deque.size());

        return count + deque.size();
    }

    public static void main(String[] args) {
        System.out.println(countMissingParanthesis("()))(("));
    }
}
