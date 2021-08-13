package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class CreateListOfLeaves {
    public static List<TreeNode> createListOfLeaves(TreeNode tree) {
        List<TreeNode> leaves = new LinkedList<>();
        addLeavesLeftToRight(tree , leaves);
        return leaves;
    }
    private static void addLeavesLeftToRight(TreeNode tree, List<TreeNode> leaves) {
        if (tree != null) {
            if (tree.left == null && tree.right == null){
                leaves.add(tree);
            } else{
                addLeavesLeftToRight(tree.left, leaves);
                addLeavesLeftToRight(tree.right, leaves);
            }
        }
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

        List<TreeNode> list = createListOfLeaves(root);

        for (TreeNode node : list) {
            System.out.print(node.val + " ");
        }
    }
}
