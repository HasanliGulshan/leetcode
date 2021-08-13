package tree;

import common.TreeNode;

public class PathSum2 {
    public static boolean hasPathSum(TreeNode tree, int targetSum) {
        return hasPathSumHelper (tree , 0, targetSum);
    }

    private static boolean hasPathSumHelper (TreeNode node, int partialPathSum , int targetSum) {
        if (node == null) {
            return false;
        }

        partialPathSum += node.val;

        if (node.left == null && node.right == null) { // Leaf.
            return partialPathSum == targetSum;
        }
           // Non-leaf
        return hasPathSumHelper(node.left , partialPathSum, targetSum)
                || hasPathSumHelper (node.right , partialPathSum, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }
}
