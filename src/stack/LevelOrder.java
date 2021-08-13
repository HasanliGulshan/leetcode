package stack;

import common.TreeNode;

import java.util.*;

public class LevelOrder {

    static TreeNode root;

    //t.c O (n) each node exactly enqueued and deque one  s.c is O(m) m is max nodes at any depths
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currDepthNode = new LinkedList<>();
        currDepthNode.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!currDepthNode.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            while (!currDepthNode.isEmpty()) {
                TreeNode node = currDepthNode.poll();

                if (node != null) {
                    level.add(node.val);

                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!level.isEmpty())
                result.add(level);

            currDepthNode = queue;
        }

        return result;
    }

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(12);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}
