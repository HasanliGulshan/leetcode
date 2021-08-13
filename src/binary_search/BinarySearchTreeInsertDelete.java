package binary_search;

import common.TreeNode;

public class BinarySearchTreeInsertDelete {

    private static TreeNode root = null;

    public static boolean insert(Integer key) {
        if (root == null) {
            root = new TreeNode(key, null, null);
        } else {
            TreeNode curr = root;
            TreeNode parent = curr;
            while (curr != null) {
                parent = curr;
                int cmp = Integer.compare(key, curr.val);
                if (cmp == 0) {
                    return false; // key already present, no duplicates to be added.
                } else if (cmp < 0) {
                    curr = curr.left;
                } else { // cmp > 0.
                    curr = curr.right;
                }
            }

            // Insert key according to key and parent.
            if (Integer.compare(key, parent.val) < 0) {
                parent.left = new TreeNode(key, null, null);
            } else {
                parent.right = new TreeNode(key, null, null);
            }
        }
        return true;
    }

    public static boolean delete(Integer key) {
        // Find the node with key.
        TreeNode curr = root, parent = null;
        while (curr != null && Integer.compare(curr.val, key) != 0) {

            parent = curr;
            curr = Integer.compare(key, curr.val) < 0 ? curr.left : curr.right;
        }
        if (curr == null) {
            // There’s no node with key in this tree.
            return false;
        }
        TreeNode keyNode = curr;
        if (keyNode.right != null) {
            // Find the minimum of the right subtree.
            TreeNode rKeyNode = keyNode.right;
            TreeNode rParent = keyNode;
            while (rKeyNode.left != null) {
                rParent = rKeyNode;
                rKeyNode = rKeyNode.left;
            }
            keyNode.val = rKeyNode.val;
            // Move links to erase the node.
            if (rParent.left == rKeyNode) {
                rParent.left = rKeyNode.right;
            } else { // rParent.left != rKeyNode.
                rParent.right = rKeyNode.right;
            }
            rKeyNode.right = null;
        } else {
            // Update root link if needed.
            if (root == keyNode) {
                root = keyNode.left;
                keyNode.left = null;
            } else {
                if (parent.left == keyNode) {
                    parent.left = keyNode.left;
                } else {
                    parent.right = keyNode.left;
                }
                keyNode.left = null;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        insert(15);
        insert(8);
        insert(5);
        insert(20);
        insert(200);
        insert(400);
        insert(40);

  //      delete(8);
        delete(200);
    }
}
