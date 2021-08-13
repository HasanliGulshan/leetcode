package tree;

import common.TreeNode;

public class LowestCommonAncestor {
    static TreeNode root;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         return LCA(root, p, q);
    }

    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q){
            return root;
        }

        TreeNode node0 = LCA(root.left, p, q);
        TreeNode node1 = LCA(root.right, p, q);

        if (node0 != null && node1 != null) return root;

        return node0 == null? node1 : node0;
    }

    public static void main(String[] args) {
        root = new TreeNode(3);

        TreeNode f = new TreeNode(5);
        TreeNode r = new TreeNode(1);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode ff = new TreeNode(4);
        root.left.right.right = ff;

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode fff  =lowestCommonAncestor(root, f, ff);
        System.out.println(fff.val);
    }
}
