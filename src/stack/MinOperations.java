package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinOperations {
    public static int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();

        for (String l : logs) {
            if (l.equals("../") && deque.size() >= 1) {
                deque.poll();
            } else if (!l.equals("../") && !l.equals("./")) {
                deque.add(l);
            }
        }

        return deque.size();
    }

    public static void main(String[] args) {
        String[] l = new String[]{};
        System.out.println(minOperations(l));
    }
}
