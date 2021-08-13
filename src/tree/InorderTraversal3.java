package tree;

import common.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal3 {
    public static List<Integer> inorderTraversal(BinaryTree tree) {
        BinaryTree prev = null, curr = tree;
        List<Integer> result = new ArrayList<>();

        while (curr != null) {
            BinaryTree next;
            if (curr.parent == prev) {

              // We came down to curr from prev.
                if (curr.left != null) { // Keep going left.
                    next = curr.left;
                } else {
                    result.add(curr.val);

            // Done with left, so go right if right is not empty.
            // Otherwise , go up.
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                result.add(curr.val);
            // Done with left, so go right if right is not empty. Otherwise , go up.
                next = (curr.right != null) ? curr.right : curr.parent;
            } else { // Done with both children , so move up.
                next = curr.parent;

            }
            prev = curr;
            curr = next;
        }
        return result;
    }

    static BinaryTree insert(BinaryTree node, int data) {
        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new BinaryTree(data));
        } else {
            BinaryTree temp = null;
            /* 2. Otherwise, recur down the tree */
            if (data <= node.val) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
            /* return the (unchanged) node pointer */
            return node;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = null, temp = null, suc = null, min = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        System.out.println(inorderTraversal(root));
    }
}
