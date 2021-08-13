package hashMap;

import common.BinaryTree;
import tree.LCA2;

import java.util.HashSet;
import java.util.Set;

public class LCA {
    static BinaryTree root, n1, n2, lca;

    public static BinaryTree LCA(BinaryTree node0,
                                           BinaryTree node1) {
        Set<BinaryTree> hash = new HashSet<>();
        while (node0 != null || node1 != null) {
// Ascend tree in tandem from these two nodes.
            if (node0 != null) {
                if ( ! hash.add(node0) ) {
                    return node0;
                }
                node0 = node0.parent ;
            }
            if (node1 != null) {
                if ( ! hash.add(node1) ) {
                    return node1;
                }
                node1 = node1.parent ;
            }
        }
        throw new IllegalArgumentException (
                "node® and nodel are not in the same tree");
    }

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

    public static void main(String[] args) {
        LCA tree = new LCA();
        root = new BinaryTree();
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        root = root.right;
        n1 = root.left.right.left;
        n2 = root.right;
        tree.lca = LCA(n1, n2);

        System.out.println(lca.val);
    }
}
