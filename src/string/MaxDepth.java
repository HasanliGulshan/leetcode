package string;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static int maxDepth(String s) {
        Queue<Character> queue = new LinkedList<>();
        int left = 0, right = 0, depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')')
                queue.add(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.remove();

            if (c == '(') {
                left++;

                while (!queue.isEmpty() && c == queue.peek()) {
                    left++;
                    queue.remove();
                }
            } else {
                right++;

                while (!queue.isEmpty() && c == queue.peek()) {
                    right++;
                    queue.remove();
                }
            }

            int res = Math.abs(left - right);

            if (res == 0) {
                depth = Math.max(depth, left);
            } else {
                depth = Math.max(depth, res);
            }

            if (left >= right) {
                left -= right;
                right = 0;
            } else {
                right -= left;
                left = 0;
            }

        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("( p((q)) ((s)t) )"));
    }
}
