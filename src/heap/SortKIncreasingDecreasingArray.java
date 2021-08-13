package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortKIncreasingDecreasingArray {

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
// Decomposes A into a set of sorted arrays.
        List<List<Integer>> sortedSubarrays = new ArrayList<>();
        SubarrayType subarrayType = SubarrayType.INCREASING;
        int startldx = 0;
        for (int i = 1; i <= A.size(); ++i) {
            if (i == A.size() || (A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING) || (A.get(i - 1) >= A.get(i)
                                                           && subarrayType == SubarrayType.INCREASING)) {
                List<Integer> subList = A.subList(startldx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubarrays.add(subList);
                startldx = i;
                subarrayType = (subarrayType == SubarrayType.INCREASING
                        ? SubarrayType.DECREASING
                        : SubarrayType.INCREASING);
            }
        }
        return ArrayEntry.mergeSortedArrays(sortedSubarrays);
    }

    private static enum SubarrayType {INCREASING, DECREASING}

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(57);
        list.add(131);
        list.add(493);
        list.add(294);
        list.add(221);
        list.add(339);
        list.add(418);
        list.add(452);
        list.add(442);
        list.add(190);

        System.out.println(sortKIncreasingDecreasingArray(list));
    }
}
