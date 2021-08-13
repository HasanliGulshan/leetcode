package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Deque<Pair<TreeNode, Boolean>> deque = new ArrayDeque<>();
        deque.addFirst(new Pair(root, false));
        int sumOfLeftLeaves = 0;

        while (!deque.isEmpty()) {
            Pair<TreeNode, Boolean> p = deque.removeFirst();
            TreeNode node = p.getKey();
            boolean isLeft = p.getValue();

            if (isLeft && node.left == null && node.right == null)
                sumOfLeftLeaves += node.val;

            if (node.right != null) {
                deque.addFirst(new Pair(node.right, false));
            }

            if (node.left != null) {
                deque.addFirst(new Pair(node.left, true));
            }
        }

        return sumOfLeftLeaves;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode f = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sumOfLeftLeaves(root));
    }
}
