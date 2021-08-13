package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFromPreorderlnorderIterative {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        int inOrderIndex = 0;
        deque.addFirst(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode prev = null;

            while (!deque.isEmpty() && deque.peekFirst().val == inorder[inOrderIndex]) {
                prev = deque.removeFirst();
                inOrderIndex++;
            }

            TreeNode push = new TreeNode(preorder[i]);


            if (prev == null) {
                prev = deque.peekFirst();
                prev.left = push;
            } else {
                prev.right = push;

            }

            deque.addFirst(push);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};


        TreeNode root = buildTree(preOrder, inOrder);

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
