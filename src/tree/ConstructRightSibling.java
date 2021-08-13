package tree;


import common.TreeNode;

public class ConstructRightSibling {
    public static void constructRightSibling(TreeNode tree) {
        TreeNode leftStart = tree;
        while (leftStart != null && leftStart.left != null){
            populateLowerLevelNextField(leftStart);
            leftStart = leftStart.left;
        }
    }

    private static void populateLowerLevelNextField(TreeNode startNode) {
        TreeNode iter = startNode;
        while (iter != null) {
        // Populate left child’s next field.
            iter.left.next = iter.right;
        // Populate right child’s next field if iter is not the last node of this
        // level .
            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);


        constructRightSibling(root);
    }
}
