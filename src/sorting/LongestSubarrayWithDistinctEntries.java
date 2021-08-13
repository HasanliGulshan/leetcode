package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarrayWithDistinctEntries {
    public static int longestSubarrayWithDistinctEntries(List<Integer> A){
// Records the most recent occurrences of each entry.
        Map<Integer , Integer> mostRecentOccurrence = new HashMap<>();
        int longestDupFreeSubarrayStartldx = 0, result = 0;
        for (int i = 0; i < A.size(); ++i) {
            Integer dupldx = mostRecentOccurrence.put(A.get(i), i);
// A.get(i) appeared before. Did it appear in the longest current
// subarray?
            if (dupldx != null) {
                if (dupldx >= longestDupFreeSubarrayStartldx) {
                    result = Math.max(result , i - longestDupFreeSubarrayStartldx);
                    longestDupFreeSubarrayStartldx = dupldx + 1;
                }
            }
        }
        result = Math.max(result , A.size() - longestDupFreeSubarrayStartldx);
        return result ;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(5);
        list.add(3);

        System.out.println(longestSubarrayWithDistinctEntries(list));

    }
}
