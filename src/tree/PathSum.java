package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.addFirst(new Pair<>(root, 0));
        int sum = 0;

        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> p = deque.removeFirst();
            TreeNode node = p.getKey();
            sum = p.getValue();

            if (node != null) {
                sum += node.val;

                //reached leaf node
                if (node.right == null && node.left == null && sum == targetSum)
                    return true;

                if (node.left != null)
                    deque.addFirst(new Pair<>(node.left, sum));

                if (node.right != null)
                    deque.addFirst(new Pair<>(node.right, sum));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }
}
