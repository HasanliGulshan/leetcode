package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Tree2str {
    public static String tree2str(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();
        deque.addFirst(root);
        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            TreeNode node = deque.peekFirst();

            if (visited.contains(node)) {
                deque.removeFirst();
                sb.append(")");
            } else {
                visited.add(node);
                sb.append("(").append(node.val);

                if (node.right != null) {
                    deque.addFirst(node.right);
                }

                if (node.left != null) {
                    deque.addFirst(node.left);
                } else if (node.right != null) {
                    sb.append("()");
                }
            }
        }

        return sb.substring(1, sb.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        System.out.println(tree2str(root));
    }
}
