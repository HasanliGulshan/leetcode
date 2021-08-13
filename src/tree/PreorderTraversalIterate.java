package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversalIterate {
    public static List<Integer> preorderTraversal(TreeNode tree) {
        List<Integer> list = new ArrayList<>();

        if (tree == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(tree);

        while (!deque.isEmpty()) {
            TreeNode curr = deque.removeFirst();

            list.add(curr.val);

            //first push right then left, so can get left from removeFirst()
            if (curr.right != null)
                deque.addFirst(curr.right);

            if (curr.left != null)
                deque.addFirst(curr.left);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(preorderTraversal(root));
    }
}
