package stack;

import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : ops) {
            if (s.equals("+")) {
               int value = stack.pop();
               int value2 = stack.peek();
               stack.push(value);
               stack.push(value + value2);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"5"};
        System.out.println(calPoints(ss));
    }
}
