package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String t : tokens) {
            if (!"+/*-".contains(t)) {
                deque.addFirst(Integer.parseInt(t));
            } else {
                int second = deque.pop();
                int first = deque.pop();
                deque.addFirst(getResult(t, first, second));
            }
        }

        return deque.isEmpty() ?  0 : deque.peekFirst();
    }

    static int getResult(String t, int first, int second) {
        if (t.equals("+")) {
            return first + second;
        } else if (t.equals("-")) {
            return first - second;
        } else if (t.equals("/")) {
            return first / second;
        } else {
            return first * second;
        }
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
