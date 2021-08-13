package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class FindTarget {
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        HashSet<Integer> set = new HashSet<>();

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            int left = k - node.val;

            if (set.contains(node.val)) {
                return true;
            } else {
                set.add(left);

                if (node.right != null)
                    deque.addFirst(node.right);

                if (node.left != null)
                    deque.addFirst(node.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode f = new TreeNode(3);
        TreeNode r = new TreeNode(6);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 28));
    }
}
