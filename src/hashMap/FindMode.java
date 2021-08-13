package hashMap;

import common.TreeNode;

import java.util.*;

public class FindMode {
    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        Map<Integer, Integer> map = new HashMap<>();
        int maxOccurred = 0;

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            int count = map.getOrDefault(node.val, 0) + 1;
            maxOccurred = Math.max(maxOccurred, count);
            map.put(node.val, count);

            if (node.right != null)
                deque.addFirst(node.right);

            if (node.left != null)
                deque.addFirst(node.left);
        }

        int[] ans = new int[map.size()];
        int index = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == maxOccurred)
                ans[index++] = m.getKey();
        }

        return Arrays.copyOf(ans, index);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode f = new TreeNode(5);
        TreeNode r = new TreeNode(5);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(6);

        System.out.println(findMode(root));

    }
}
