package tree;

import common.TreeNode;

public class MaxDepth {
    static TreeNode root;
    public static int maxDepth(TreeNode root) {
        {
            // Root being null means tree doesn't exist.
            if (root == null)
                return 0;

            // Get the depth of the left and right subtree
            // using recursion.

            int leftDepth = maxDepth(root.left);
            System.out.println("leftDepth " + leftDepth);
            int rightDepth = maxDepth(root.right);
            System.out.println("rightDepth " + rightDepth);

            //+1 includes root
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        MaxDepth tree = new MaxDepth();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));

    }
}
