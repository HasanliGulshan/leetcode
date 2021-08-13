package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MakeGood {
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (deque.size() >= 1 && Math.abs(deque.peek() - c) == 32) {
                deque.poll();
            } else {
                deque.push(c);
            }
        }

        for (Iterator iter = deque.descendingIterator(); iter.hasNext();) {
            sb.append(iter.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("Pp"));
    }
}
