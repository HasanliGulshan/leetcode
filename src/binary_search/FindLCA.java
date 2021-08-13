package binary_search;

import common.TreeNode;

public class FindLCA {
    public static TreeNode  findLCA (TreeNode  tree, TreeNode  s, TreeNode b) {
        return findLCAHelper(tree, s, b);
    }

    public static TreeNode findLCAHelper(TreeNode  tree, TreeNode  s, TreeNode b) {
        if (tree.val < Math.min(s.val, b.val)) {
            return findLCAHelper(tree.right, s, b);
        } else if (tree.val > Math.max(s.val, b.val)){
            return findLCAHelper(tree.left, s, b);
        } else {
            return tree;
        }
    }
}
