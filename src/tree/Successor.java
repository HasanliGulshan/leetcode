package tree;

import common.BinaryTree;

public class Successor {

    public static BinaryTree findSuccessor(BinaryTree node) {
        BinaryTree iter = node;
        if (iter.right != null) {
        // Find the leftmost element in node’s right subtree.
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }
        // Find the closest ancestor whose left subtree contains node.
        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
    // A return value of null means node does not have successor , i.e., it is
    // the rightmost node in the tree.
        return iter.parent;
    }

   static BinaryTree insert(BinaryTree node, int data)
    {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new BinaryTree(data));
        }
        else {
            BinaryTree temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.val) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    public static void main(String[] args) {
        Successor tree = new Successor();
        BinaryTree root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);

        temp = root.left.right.right;

        BinaryTree tt = findSuccessor(root);

        System.out.println(tt.val);
    }
}
