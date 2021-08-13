package tree;

import common.ListNode;
import common.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        int level = 0;

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        List<List<Double>> res = new ArrayList<>();

        deque.addFirst(new Pair<>(root, level));

        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> p = deque.removeFirst();
            TreeNode node = p.getKey();
            double sum = node.val;
            level = p.getValue();

            if (level < res.size()) {
                res.get(level).add(sum);

            } else {
                List<Double> v = new ArrayList<>();
                v.add(sum);
                res.add(v);
            }

            level++;

            if (node.right != null)
                deque.addLast(new Pair<>(node.right, level));

            if (node.left != null)
                deque.addLast(new Pair<>(node.left, level));
        }

        List<Double> ans = new ArrayList<>();

        for (List<Double> r : res) {
            System.out.println(r);
            double sum = r.stream().reduce(0.0, Double::sum);
            ans.add(sum / r.size());
        }

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode f = new TreeNode(5);
        TreeNode r = new TreeNode(1);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode ff = new TreeNode(4);
        root.left.right.right = ff;

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(averageOfLevels(root));
    }
}
