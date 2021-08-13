package tree;

import common.TreeNode;

public class InvertTree {
    static TreeNode root;
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        InvertTree tree = new InvertTree();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(7);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(9);

        invertTree(root);

        /*System.out.print(root.val);
        while (root != null) {
            System.out.print(root.right.val + " " + root.left.val);

            root = root.right;
            root = root.left;
        }*/
    }
}
