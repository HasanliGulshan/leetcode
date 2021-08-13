package stack;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] warm = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T [i] >= T[stack.peek()]) {
                stack.pop();
            }
            warm[i] = !stack.isEmpty() ? stack.peek() - i : 0;
            stack.push(i);
        }

        return warm;
    }

    public static void main(String[] args) {
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] w = dailyTemperatures(T);

        for (int h : w) {
            System.out.print(h + " ");
        }
    }
}
