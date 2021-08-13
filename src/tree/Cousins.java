package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Cousins {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.addFirst(new Pair(root, 0));
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        while (!deque.isEmpty() && list.size() <= 2) {
            Pair p = deque.removeFirst();
            TreeNode node = (TreeNode) p.getKey();
            int depth = (int) p.getValue() + 1;

            if (node.right != null) {
                deque.add(new Pair(node.right, depth));

                if (node.right.val == x || node.right.val == y) {
                    list.add(new Pair(node.val, depth));
                }
            }


            if (node.left != null) {
                deque.add(new Pair(node.left, depth));

                if (node.left.val == x || node.left.val == y) {
                    list.add(new Pair(node.val, depth));
                }
            }

        }

        if (list.size() == 2) {
            Pair<Integer, Integer> xP = list.get(0);
            Pair<Integer, Integer> yP = list.get(1);

            return !xP.getKey().equals(yP.getKey()) && xP.getValue().equals(yP.getValue());
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode f = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = f;

        root.right = r;

        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 5, 4));

    }
}
