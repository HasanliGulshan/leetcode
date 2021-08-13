package arrays;

import java.util.List;

public class SearchSmallest {
    public static int searchSmallest(List<Integer> A) {
        int left = 0, right = A.size() - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (A.get(mid) > A.get(right)) {
// Minimum must be in A.subList(mid + 1, right + 1).
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }
}
