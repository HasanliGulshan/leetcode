package tree;

import common.TreeNode;

public class PostOrder {
    static TreeNode root;
     static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return diameter;
    }

     static int postOrder(TreeNode root){
        if(root == null) return 0;
        int leftSize = postOrder(root.left);
        int rightSize = postOrder(root.right);
        diameter = Math.max(diameter, leftSize + rightSize);
        return Math.max(leftSize, rightSize) + 1;
    }

    public static void main(String[] args) {
        PostOrder tree = new PostOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
