package tree;

import common.TreeNode;

public class BSTFromPreorder {
    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode curr = root, prev = null;
            while (curr != null) {
                prev = curr;
                if (preorder[i] > curr.val)
                    curr = curr.right;
                else curr = curr.left;
            }
            if (prev.val < preorder[i])
                prev.right = new TreeNode(preorder[i]);
            else prev.left = new TreeNode(preorder[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,5, 12};
//8,5,1,7,10,5, 12  4, 10, 7, 9, 11
        TreeNode root = bstFromPreorder(preorder);
        levelOrder(root);
    }

    static void levelOrder(TreeNode root) {
        System.out.print(root.val + " ");

        if (root.left != null) {
            levelOrder(root.left);
        }

        if (root.right != null) {
            levelOrder(root.right);
        }
    }
}
