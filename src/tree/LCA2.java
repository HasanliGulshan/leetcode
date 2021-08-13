package tree;

import common.BinaryTree;

public class LCA2 {
    static BinaryTree root, n1, n2, lca;

    static BinaryTree insert(BinaryTree node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new BinaryTree(key);

        /* Otherwise, recur down the tree */
        if (key < node.val) {
            node.left = insert(node.left, key);
            node.left.parent = node;
        } else if (key > node.val) {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    public static BinaryTree LCA(BinaryTree node0, BinaryTree node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
// Makes node(9 as the deeper node in order to simplify the code.
        if (depth1 > depth0) {
            BinaryTree temp = node0;
            node0 = node1;
            node1 = temp;
        }
// Ascends from the deeper node.
        int depthDiff = Math.abs(depth0 - depth1);
        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }
// Now ascends both nodes until we reach the LCA.
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }


    private static int getDepth(BinaryTree node) {
        int depth = 0;
        while (node.parent != null) {
            ++depth;
            node = node.parent;
        }
        return depth;
    }

    public static void main(String[] args) {
        LCA2 tree = new LCA2();
        root = new BinaryTree();
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        tree.n1 = root.left.right.left;
        tree.n2 = root.right;
        tree.lca = LCA(tree.n1, tree.n2);

        System.out.println(lca.val);
    }
}
