package tree;

import common.TreeNode;

public class Status {
    public int numTargetNodes;
    public TreeNode ancestor;

    public Status(int numTargetNodes, TreeNode node) {
        this.numTargetNodes = numTargetNodes;
        this.ancestor = node;
    }

    public static TreeNode LCA(TreeNode tree, TreeNode node0, TreeNode node1) {

        return LCAHelper(tree, node0, node1).ancestor;
    }

        // Returns an object consisting of an int and a node. The int field is
    // 0, 1, or 2 depending on how many of {node0 , node1} are present in
    // the tree. If both are present in the tree, when ancestor is
    // assigned to a non-null value, it is the LCA.
    private static Status LCAHelper(TreeNode tree, TreeNode node0, TreeNode node1) {
        if (tree == null) {
            return new Status(0, null);
        }
        Status leftResult = LCAHelper(tree.left, node0, node1);
        if (leftResult.numTargetNodes == 2) {
// Found both nodes in the left subtree.
            return leftResult;
        }
        Status rightResult = LCAHelper(tree.right, node0, node1);
        if (rightResult.numTargetNodes == 2) {
// Found both nodes in the right subtree.
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes
                + (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
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

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Status status = new Status(2, root);

        TreeNode fff = LCA(root, f, ff);
        System.out.println(fff.val);
    }
}
