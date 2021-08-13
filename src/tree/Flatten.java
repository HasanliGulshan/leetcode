package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Flatten {
    public static void flatten(TreeNode root) {
       if (root == null) return;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        TreeNode child = root;

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            if (node.right != null)
                deque.addFirst(node.right);

            if (node.left != null)
                deque.addFirst(node.left);

            if (node != root) {
                child.right = node;
                child = child.right;
            }

            if (node.left != null)
                node.left = null;

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);
    }
}
