package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargest {

    int kth;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
       this.kth = k;
       queue = new PriorityQueue<>();

       for (int n : nums)
           queue.add(n);

    }

    public int add(int val) {
        queue.add(val);

        while (queue.size() > kth) {
            queue.poll();
        }

        return queue.element();
    }

    public static void main(String[] args) {
        int[] n = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, n);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
    }
}
