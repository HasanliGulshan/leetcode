package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContainedRange {
    public static int longestContainedRange(List<Integer> A) {
        // unprocessedEntries records the existence of each entry in A.
        Set<Integer> unprocessedEntries = new HashSet<>(A);
        int maxIntervalSize = 0;
        while (!unprocessedEntries.isEmpty()) {
            int a = unprocessedEntries.iterator().next();
            unprocessedEntries.remove(a);
// Finds the lower bound of the largest range containing a.
            int lowerBound = a - 1;
            while (unprocessedEntries.contains(lowerBound)) {
                unprocessedEntries.remove(lowerBound);
                --lowerBound;
            }
// Finds the upper bound of the largest range containing a.
            int upperBound = a + 1;
            while (unprocessedEntries.contains(upperBound)) {
                unprocessedEntries.remove(upperBound);
                ++upperBound;
            }
            maxIntervalSize = Math.max(upperBound - lowerBound - 1, maxIntervalSize);
        }
        return maxIntervalSize;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(10);
        list.add(3);
        list.add(11);
        list.add(5);
        list.add(100);
        list.add(4);
        //3 4 5 6
        //10 11
        //100
        //largest size 4

        System.out.println(longestContainedRange(list));
    }
}
