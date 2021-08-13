/*
package tree;

import common.TreeNode;

public class BinaryTreeLock {
    private TreeNode left, right, parent;
    private boolean locked = false;
    private int numLockedDescendants = 0;

    public boolean isLocked() {
        return locked;
    }

    public boolean lock() {
        // file cannot lock if any of this node’s descendants are locked.
        if (numLockedDescendants > || isLocked()){
            return false;
        }
        // We cannot lock if any of this node’s ancestors are locked.
        for (TreeNode iter = parent; iter != null; iter = iter.parent) {
            if (iter.locked) {
                return false;
            }
        }
        // Lock this node and increments all its ancestors’s descendant lock
        // counts.
        locked = true;
        for (TreeNode iter = parent; iter != null; iter = iter.parent) {
            ++iter.numLockedDescendants;
        }
        return true;

    }

    public void unlock() {
        if (locked) {
// Unlocks itself and decrements its ancestors ’s descendant lock counts.
            locked = false;
            for (TreeNode iter = parent; iter != null; iter = iter.parent) {
                --iter.numLockedDescendants;
            }
        }
    }
}
*/
