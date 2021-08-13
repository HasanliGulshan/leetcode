package tree;

import common.TreeNode;

public class SymmetricTree2 {
static TreeNode root;
    public static boolean isSymmetric (TreeNode tree) {
        return tree == null || checkSymmetric (tree.left , tree.right);
    }

    private static boolean checkSymmetric (TreeNode subtree0, TreeNode subtree1) {
        if (subtree0 == null && subtree1 == null) {
            return true;
        } else if (subtree0 != null && subtree1 != null){
            return subtree0.val == subtree1.val && checkSymmetric(subtree0.left, subtree1.right) && checkSymmetric(subtree0.right, subtree1.left);
        }

        //if any subtree is null then return false;

        return false;
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(20);

        root.right.right = new TreeNode(40);
        root.left.left = new TreeNode(40);

        root.right.left = new TreeNode(50);
        root.left.right = new TreeNode(50);

        System.out.println(isSymmetric(root));
    }
}
