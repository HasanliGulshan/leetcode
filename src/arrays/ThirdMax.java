package arrays;

import java.util.PriorityQueue;

public class ThirdMax {
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> set = new PriorityQueue<>();

        for (int n : nums)
            if (!set.contains(n))
             set.add(n);

        int max = 0, count = set.size() - 3;

        if (set.size() >=3) {
            while (count >= 0 && !set.isEmpty()) {
                max = set.poll();
                count--;
            }
        } else {
            while (!set.isEmpty())
                max = set.poll();
        }

        return max;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2, 2, 3,1};
        System.out.println(thirdMax(n));
    }
}
