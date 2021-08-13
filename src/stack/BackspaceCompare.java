package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class BackspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> deque = new ArrayDeque<>();
        getCorrectText(deque, s);
        StringBuilder sb = new StringBuilder();
        getSB(deque, sb);
        deque.clear();

        getCorrectText(deque, t);

        getSB(deque, sb);

        if (sb.length() %2 != 0) return false;

        for (int i = 0, j = sb.length()/2; i < sb.length()/2 && j < sb.length(); i++, j++) {
            if (sb.charAt(i) != sb.charAt(j)) return false;
        }

        return true;
    }

    static void getCorrectText(Deque<Character> deque, String s) {
        for (char c : s.toCharArray()) {
            if (deque.size() >= 1 && c == '#') {
                deque.poll();
            } else if (deque.isEmpty() && c == '#') {
            } else {
                deque.push(c);
            }
        }
    }

    static void getSB(Deque deque, StringBuilder sb) {
        for (Iterator<Character> iter = deque.descendingIterator(); iter.hasNext();) {
            sb.append(iter.next());
        }
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
