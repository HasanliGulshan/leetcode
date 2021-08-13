package tree;

import common.TreeNode;

public class BalanceStatusWithHeight {
    static TreeNode root;
    public boolean balanced;
    public int height;

    BalanceStatusWithHeight(boolean balanced, int value) {
        this.balanced = balanced;
        this.height = value;
    }

    public static boolean isBalanced(TreeNode tree) {
        return checkBalanced(tree).balanced;
    }

    public static BalanceStatusWithHeight checkBalanced(TreeNode tree) {
            if (tree == null) {
                return new BalanceStatusWithHeight(true , -1); // Base case.
            }

            BalanceStatusWithHeight leftResult = checkBalanced(tree.left);

            if (!leftResult.balanced) {
                return leftResult; // Left subtree is not balanced.
            }

            BalanceStatusWithHeight rightResult = checkBalanced(tree.right);

            if (!rightResult.balanced) {
                return rightResult; // Right subtree is not balanced.
            }

            boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
            int height = Math.max(leftResult.height , rightResult.height) + 1;

            return new BalanceStatusWithHeight(isBalanced , height);
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.right.left = new TreeNode(40);
        root.left.left = new TreeNode(60);

        root.right.left.left = new TreeNode(80);
        root.left.left.left = new TreeNode(100);

        System.out.println(isBalanced(root));
    }
}
