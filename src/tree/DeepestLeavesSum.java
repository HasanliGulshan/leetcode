package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum {
    public static int deepestLeavesSum(TreeNode root) {
       if (root == null) return 0;

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        deque.addFirst(new Pair(root, 0));
        int maxDepth = 0;

        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> p = deque.removeFirst();
            TreeNode node = p.getKey();
            int depth = p.getValue();

            maxDepth = Math.max(depth, maxDepth);

            if (node.left == null && node.right == null && depth == maxDepth)
                 map.put(node, depth);

            if (node.right != null)
                deque.addFirst(new Pair(node.right, depth + 1));

            if (node.left != null)
                deque.addFirst(new Pair(node.left, depth + 1));
        }

        int sum = 0;

        for (Map.Entry<TreeNode, Integer> m : map.entrySet()) {
            if (m.getValue() == maxDepth) {
                sum += m.getKey().val;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        System.out.println(deepestLeavesSum(root));
    }
}
