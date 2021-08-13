package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeafSimilar {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rootA = new ArrayList<>();
        rootA = getLeafs(rootA, root1);
        List<Integer> rootB = new ArrayList<>();
        rootB = getLeafs(rootB, root2);

        System.out.println(rootA);
        System.out.println(rootB);

        return rootA.equals(rootB);
    }

    static List<Integer> getLeafs(List<Integer> list, TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();

            if (node.right == null && node.left == null)
                list.add(node.val);

            if (node.right != null)
                deque.addFirst(node.right);

            if (node.left != null)
                deque.addFirst(node.left);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode f = new TreeNode(5);
        TreeNode r = new TreeNode(1);
        root.left = f;

        root.right = r;

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode ff = new TreeNode(4);
        root.left.right.right = ff;

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);

        TreeNode fff = new TreeNode(5);
        TreeNode rr = new TreeNode(1);
        root2.left = fff;

        root2.right = rr;

        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);


        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);

        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root, root2));
    }
}
