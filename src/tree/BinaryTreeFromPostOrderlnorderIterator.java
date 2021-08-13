package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeFromPostOrderlnorderIterator {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        deque.addFirst(root);
        int inOrderIndex = inorder.length - 1;

        for (int i = inorder.length - 2; i >= 0; i--) {
            TreeNode prev = null;

            while (!deque.isEmpty() && deque.peekFirst().val == inorder[inOrderIndex]) {
                prev = deque.removeFirst();
                inOrderIndex--;
            }

            TreeNode push = new TreeNode(postorder[i]);

            if (prev == null) {
                prev = deque.peekFirst();
                prev.right = push;
            } else {
                prev.left = push;
            }

            deque.addFirst(push);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = new int[] {9,3,15,20,7};
        int[] postOrder = new int[] {9,15,7,20,3};

        TreeNode root = buildTree(inOrder, postOrder);

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
