package binary_search;

import common.TreeNode;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

   static TreeNode constructTreeFromArray(int[] nums, int start, int end) {
        if (end < start) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructTreeFromArray(nums, start, mid - 1);
        root.right = constructTreeFromArray(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
