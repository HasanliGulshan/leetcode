package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);

            while (!deque.isEmpty() && deque.peekFirst() == popped[j]) {
                deque.removeFirst();
                j++;
            }
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[] {1,2,3,4,5};
        int[] popped = new int[] {4,3,5,1,2};


        System.out.println(validateStackSequences(pushed, popped));
    }
}
