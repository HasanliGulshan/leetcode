package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class UnivalTree {
    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        int val = root.val;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            if (node.val != val) {
                return false;
            } else {
                if (node.left != null)
                    deque.addFirst(node.left);
                if (node.right != null)
                    deque.addFirst(node.right);
            }
        }

        return true;
    }

    //recursion
   /* public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        System.out.println(isUnivalTree(root));
    }
}
