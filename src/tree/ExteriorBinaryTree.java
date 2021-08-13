package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ExteriorBinaryTree {
    public static List<TreeNode> exteriorBinaryTree(TreeNode tree) {
        List<TreeNode> exterior = new LinkedList<>();
        if (tree != null) {
            exterior.add(tree);
            exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
            exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
        }
        return exterior;
    }

    // Computes the nodes from the root to the leftmost leaf followed by all the
    // leaves in subtreeRoot.
    private static List<TreeNode> leftBoundaryAndLeaves(TreeNode subtreeRoot, boolean isBoundary) {
        List<TreeNode> result = new LinkedList<>();
        if (subtreeRoot != null) {
            if (isBoundary || isLeaf(subtreeRoot)) {
                result.add(subtreeRoot);
            }
            result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
            result.addAll(leftBoundaryAndLeaves(
                    subtreeRoot.right, false));
        }
        return result;
    }

    // Computes the leaves in left-to-right order followed by the rightmost leaf
    // to the root path in subtreeRoot.
    private static List<TreeNode> rightBoundaryAndLeaves(TreeNode subtreeRoot, boolean isBoundary) {
        List<TreeNode> result = new LinkedList<>();
        if (subtreeRoot != null) {
            result.addAll(rightBoundaryAndLeaves(
                    subtreeRoot.left, false));
            result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
            if (isBoundary || isLeaf(subtreeRoot)) {
                result.add(subtreeRoot);
            }
        }
        return result;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(7);

        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        List<TreeNode> list = exteriorBinaryTree(root);

        for (TreeNode node : list) {
            System.out.print(node.val + " ");
        }
    }
}
