package tree;

import common.TreeNode;

public class TreeTraversal {
    static TreeNode root;
    public static void treeTraversal(TreeNode root) {
        if (root != null) {
            // Preorder: Processes the root before the traversals of left and right
            // children.
            //System.out.println("Preorder : " + root.val);

            treeTraversal(root.left);
            // Inorder: Processes the root after the traversal of left child and
            // before the traversal of right child.
           // System.out.println("Inorder : " + root.val);

            treeTraversal(root.right);
            // Postorder: Processes the root after the traversals of left and right
            // children.
           System.out.println("Postorder : " + root.val);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);
        root.right.right.right = new TreeNode(90);
        root.left.left = new TreeNode(60);

        root.right.left.left = new TreeNode(80);
        root.left.left.left = new TreeNode(100);

        treeTraversal(root);
    }
}
