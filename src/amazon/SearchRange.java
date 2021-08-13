package amazon;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int avrIdx = binarySearch(nums, 0, nums.length - 1, target);

        if (avrIdx == -1) return new int[]{-1, -1};

        int[] indexes = new int[2];
        int idx = avrIdx;

        while (idx >= 0 && nums[idx] == target) {
            idx--;
        }

        indexes[0] = idx + 1;
        avrIdx++;

        while (avrIdx < nums.length && nums[avrIdx] == target) {
            avrIdx++;
        }

        indexes[1] = avrIdx - 1;

        for (int p : indexes) System.out.print(p +  " ");
        return indexes;
    }

    static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target)
                start = mid + 1;

            if (nums[mid] > target)
                end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        searchRange(new int[]{2}, 2);
    }
}
