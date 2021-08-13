package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        /*PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) queue.add(n);

        while (!queue.isEmpty() && k > 1) {
            k--;
            queue.poll();
        }

        return queue.element();*/

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Build a Min Heap of the first k elements (arr[0] to arr[k-1]) of the given array.  *O(log(k))2).*
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        // For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of pq
        for (int i = k; i < nums.length; i++) {
            //a) If the element is greater than the root then make it root and call heapify for pq
            //b) Else ignore it.
            if (nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        //Finally, pq has k largest elements and root of the MH is the kth largest element.
        return pq.remove();
    }

    public static void main(String[] args) {
        int[] n = new int[] {3,2,1,5,6,4};

        System.out.println(findKthLargest(n, 2));
    }
}
