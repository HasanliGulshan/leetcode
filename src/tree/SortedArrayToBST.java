package tree;

import common.TreeNode;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    ////////////////////////?///////////////////////
    static TreeNode constructTreeFromArray(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            System.out.println("NOTHING TO RETURN");
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructTreeFromArray(nums, start, mid - 1);
        root.right = constructTreeFromArray(nums, mid + 1, end);

        return root;
    }

    static void preorder(TreeNode node) {
        if (node == null)
            return;

        // Traverse root
        System.out.print(node.val + "->");
        // Traverse left
        preorder(node.left);
        // Traverse right
        preorder(node.right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);
        preorder(root);
    }
}
