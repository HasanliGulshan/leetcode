package sorting;

import javafx.util.Pair;

import java.util.*;

public class KClosest {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<int[], Double>> minHeap = new PriorityQueue<>((o1, o2) -> {
            int dis1 = o1.getKey()[0] * o1.getKey()[0] + o1.getKey()[1] * o1.getKey()[1];
            int dis2 = o2.getKey()[0] * o2.getKey()[0] + o2.getKey()[1] * o2.getKey()[1];
            return dis2 - dis1;
        });

        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            minHeap.add(new Pair<>(points[i], distance));

            if (minHeap.size() > k) minHeap.poll();
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while (!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll().getKey();
        }

        for (int[] a : ans) {
            System.out.println(a[0] + "  " +  a[1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        //[[1,3],[-2,2]], k = 1
        int[][] req = {{3, 3}, {5, -1}, {-2, 4}};

        kClosest(req, 2);

    }
}
