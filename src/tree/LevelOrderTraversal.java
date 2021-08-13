package tree;

import common.ListNode;
import common.TreeNode;

import java.util.*;

public class LevelOrderTraversal {
    static TreeNode root;

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Integer> num;
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println("size : " + queue.size());
            int size = queue.size();
            num = new ArrayList<>();
            res.add(num);

            while (size --> 0) {
                TreeNode node = queue.poll();

                num.add(node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));
    }
}
