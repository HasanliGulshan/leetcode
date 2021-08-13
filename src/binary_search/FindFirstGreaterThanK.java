package binary_search;

import common.TreeNode;

public class FindFirstGreaterThanK {
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode subtree = root, firstSoFar = null;
        while (subtree != null) {
            if (subtree.val > val) {
                firstSoFar = subtree;
                subtree = subtree.left ;
            } else { // Root and all keys in left-subtree are <= k, so skip them.
                subtree = subtree.right ;
            }
        }
        return firstSoFar;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(5);
        node.right = new TreeNode(7);

        searchBST(node, 3);
    }
}
