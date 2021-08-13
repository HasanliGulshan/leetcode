package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTInSortedOrder {
    public static List<Integer> BSTInSortedOrder(TreeNode tree) {
        List<Integer> list = new ArrayList<>();
        if (tree == null) return list;

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = tree;

        while (curr != null || !deque.isEmpty()) {

            if (curr != null) {
                deque.addFirst(curr);
                curr = curr.left;
            } else {
                 curr = deque.removeFirst();
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(BSTInSortedOrder(root));

    }
}
