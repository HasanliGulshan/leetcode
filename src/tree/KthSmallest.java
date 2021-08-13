package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        int n = 0;

        while (curr != null || !deque.isEmpty()) {
            if (curr != null) {
                deque.addFirst(curr);
                curr = curr.left;
            } else {
                curr = deque.removeFirst();
                n++;

                if (n == k) return curr.val;
                curr = curr.right;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1));
    }
}
