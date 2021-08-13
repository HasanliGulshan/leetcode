package sorting;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetKth {
    public static int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            int comp = o1.getValue() - o2.getValue();
            return comp != 0 ? comp : o1.getKey() - o2.getKey();
        });

        for (int i =lo; i <= hi; i++) {
            int count = makeOne(i, 0);
            System.out.println(count);
            queue.add(new Pair<>(i, count));
        }

        int res = 0;
        while (k -- >0) {
            res = queue.remove().getKey();
        }

        return res;
    }

    static int makeOne(int n, int count) {
        if (n == 1) {
            return count;
        }else if (n %2 == 0) {
            n =n /2;
            count = count + 1;

        } else {
            n = n * 3 + 1;
            count = count + 1;
        }

        return  makeOne(n, count);
    }

    public static void main(String[] args) {
        System.out.println("res: " + getKth(1, 1, 1));
    }
}
