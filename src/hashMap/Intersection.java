package hashMap;

import java.util.HashMap;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1Map = new HashMap<>();
        HashMap<Integer, Integer> nums2Map = new HashMap<>();

        for (int n : nums1) nums1Map.put(n, nums1Map.getOrDefault(n, 0) + 1);

        for (int n : nums2) nums2Map.put(n, nums2Map.getOrDefault(n, 0) + 1);

        nums2Map.keySet().retainAll(nums1Map.keySet());
        int[] res = new int[nums2Map.size()];
        int i = 0;

        for (int k : nums2Map.keySet()) res[i++] = k;

        for (int r : res) System.out.print(r + " ");

        return res;
    }

    public static void main(String[] args) {
        int[] n = new int[]{4,9,5}, nums2 = new int[]{9,4,9,8,4};
        System.out.println(intersection(n, nums2));
    }
}
