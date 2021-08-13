package tree;

import common.TreeNode;

public class LowestCommonAncestor2 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         return lca(root, p, q);
    }

    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }
        TreeNode nodeL = lca(root.left, p, q);
        TreeNode nodeR = lca(root.right, p, q);

        if (nodeL != null && nodeR != null) {
            return root;
        }

        return nodeL == null ? nodeR : nodeL;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        TreeNode f = new TreeNode(2);
        TreeNode r = new TreeNode(8);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        TreeNode ff = new TreeNode(5);
        root.left.right.right = ff;

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode fff  =lowestCommonAncestor(root, f, ff);
        System.out.println(fff.val);
    }
}
