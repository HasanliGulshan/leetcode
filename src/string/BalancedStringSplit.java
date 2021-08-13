package string;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {
        Queue<Character> stack = new LinkedList<>();
        int countR = 0, countL = 0, ans = 0;
        char c;

        for (char cc : s.toCharArray()) stack.add(cc);

        while (!stack.isEmpty()) {
            c = stack.remove();

            if (c == 'R') {
                countR++;
            } else {
                countL++;
            }

            if ((countL != 0 && countR != 0) && countL == countR) {
                ans++;

                countR = 0;
                countL = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}
