package tree;

import common.TreeNode;

import java.util.*;

public class FindSecondMinimumValue {
    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        Set<Integer> set = new HashSet<>();

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            if (!isLeaf(node)) {
                set.add(Math.min(node.left.val, node.right.val));

                deque.addFirst(node.right);
                deque.addFirst(node.left);
            } else {
                set.add(node.val);
            }
        }

        if (set.size() == 1) return -1;

        List list = new ArrayList<>(set);
        Collections.sort(list);

        return (int) list.get(1);
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        //   root.left.left = new TreeNode(6);
        root.right = new TreeNode(5);

      root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
      /* [2,2,]   root.right.right.right = new TreeNode(2);
        root.right.left.right = new TreeNode(10);
        root.right.left.left = new TreeNode(8);
        root.right.left.left.right = new TreeNode(2);*/

        System.out.println(findSecondMinimumValue(root));
    }
}
