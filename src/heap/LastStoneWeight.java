package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer weight1, Integer weight2) {
                return weight1 > weight2 ? -1 : 1;
            }
        });

        for (int stone : stones) {
            queue.add(stone);
        }

        System.out.println(queue);

        while (!queue.isEmpty() && queue.size() >= 2) {
            int w1 = queue.poll();
            int w2 = queue.poll();

            if (w1 != w2) {
                queue.add(w1 - w2);
            }
        }

        return queue.size() == 1 ? queue.poll() : 0;
    }

    public static void main(String[] args) {
        int[] q = new int[]{2, 7};
        System.out.println(lastStoneWeight(q));
    }
}
