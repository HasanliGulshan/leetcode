package tree;

import common.TreeNode;

import java.util.*;

public class FindElements {
    static HashSet<Integer> list = new HashSet<>();

    public FindElements(TreeNode root) {
       getAllCorrectValues(root);
        System.out.println(list);
    }

    public boolean find(int target) {
        return list.contains(target);
    }

    void getAllCorrectValues(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        root.val = 0;
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            list.add(node.val);

            if (node.right != null) {
                node.right.val = node.val * 2 + 2;
                deque.addFirst(node.right);
            }

            if (node.left != null) {
                node.left.val = node.val * 2 + 1;
                deque.addFirst(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
       // root.left = new TreeNode(-1);

        root.right.left = new TreeNode(-1);
        root.right.left.left = new TreeNode(-1);
        boolean param_1 = new FindElements(root).find(5);

        System.out.println(param_1);
    }
}
