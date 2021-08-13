package heap;

import java.util.PriorityQueue;

public class MaximumScore {
    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((stone1, stone2) -> stone1 >= stone2 ? -1 : 1);

        queue.add(a);
        queue.add(b);
        queue.add(c);
        int score = 0;

        while (!queue.isEmpty() && queue.size() >= 2) {
            int val1 = queue.poll();
            int val2 = queue.poll();

            score++;
            if ((val1 - 1) != 0)
                   queue.add(val1 - 1);

             if ((val2 - 1) != 0)
                queue.add(val2 - 1);
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(1, 8, 8));
    }
}
