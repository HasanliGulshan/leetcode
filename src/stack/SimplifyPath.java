package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path.isEmpty()) return path;

        Deque<String> deque = new ArrayDeque<>();

        String[] tokens = path.split("/");

        for (String token : tokens) {
            //  /../ -> / cant be removed
            if (token.equals("..")) {
                if (deque.size() >= 1) deque.removeFirst();
            } else if (token.equals(".")) {

            } else if (!token.isEmpty()){
                deque.addFirst("/" + token);
            }
        }

        if (deque.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        for (Iterator iter = deque.descendingIterator(); iter.hasNext();)
            sb.append(iter.next());

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
