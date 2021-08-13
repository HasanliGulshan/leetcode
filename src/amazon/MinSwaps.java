package amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinSwaps {
    public static int minSwaps(String s) {
        int minSwap = 0, opened = 0, closed = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                opened++;

            if (s.charAt(i) == ']')
                closed++;

            if (closed > opened) {

                closed--;
                opened++;
                minSwap++;
            }
        }

        return minSwap;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("[]"));
    }
}
