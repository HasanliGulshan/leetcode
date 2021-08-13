package tree;

import common.TreeNode;

public class SumRootToLeaf2 {
    public static int sumRootToLeaf(TreeNode tree) {
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(TreeNode tree, int partialPathSum) {
        if (tree == null)
            return 0;

        partialPathSum = partialPathSum * 2 + tree.val;

        if (tree.left == null && tree.right == null) // Leaf.
            return partialPathSum;

         // Non-leaf .
        int sum = sumRootToLeafHelper(tree.left, partialPathSum)
                + sumRootToLeafHelper(tree.right, partialPathSum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(root));
    }
}
