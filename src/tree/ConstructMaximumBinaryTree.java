package tree;

import common.TreeNode;

public class ConstructMaximumBinaryTree {

    static TreeNode node;

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(0, nums.length, nums);
    }

    public static TreeNode constructMaximumBinaryTreeHelper(int start, int end, int[] nums) {
        if (start == end) return null;

        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(maxValue);
        node.left = constructMaximumBinaryTreeHelper(start, maxIndex, nums);

        node.right = constructMaximumBinaryTreeHelper(maxIndex + 1, end, nums);

        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        TreeNode root = constructMaximumBinaryTree(nums);
        inOrderTraversal(root);
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

}
