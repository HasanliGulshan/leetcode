package binary_search;

import common.TreeNode;

public class SearchBST {
    //t.c O(h) h is height of tree
    public static TreeNode searchBST(TreeNode tree, int key) {
        if (tree == null || tree.val == key) {
            return tree;
        }
        return key < tree.val ? searchBST(tree.left, key) : searchBST(tree.right, key);
    }
}
