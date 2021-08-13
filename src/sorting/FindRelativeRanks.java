package sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindRelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] rank = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            maxHeap.add(score[i]);
            map.put(score[i], i);
        }

        int k = 1;
        while (!maxHeap.isEmpty()) {
            int value = maxHeap.remove();
            if (k == 1) {
                rank[map.get(value)] = "Gold Medal";
            } else if (k == 2) {
                rank[map.get(value)] = "Silver Medal";
            } else if (k == 3) {
                rank[map.get(value)] = "Bronze Medal";
            } else {
                rank[map.get(value)] = String.valueOf(k);
            }
            k++;
        }

        for (String r : rank) System.out.print(r + " ");

        return rank;
    }

    public static void main(String[] args) {
        findRelativeRanks(new int[]{10, 3, 8, 9, 4});
    }
}
