package sorting;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class SortByBits {
    public static int[] sortByBits(int[] arr) {
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : Integer.compare(o1.getValue(), o2.getValue()));

        for (int a : arr) {
            int key = a;

            int setBit = 0;

            while (a > 0) {
                setBit += a&1;
                a >>= 1;
            }

            heap.add(new Pair(key, setBit));
        }

        int index = 0;
        while (!heap.isEmpty()) {
            arr[index++] = heap.remove().getKey();
        }

        for (int a : arr) System.out.print(a + " ");

        return arr;
    }

    public static void main(String[] args) {
        sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
    }
}
