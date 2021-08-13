package tree;

import common.TreeNode;

public class MergeTrees {
    static TreeNode root1;
    static TreeNode root2;

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {return root2;} else {
            System.out.println("heccccc");
        }
        if (root2 == null) {return root1;} else {
            System.out.println("ikinci heccccc");
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    static void preorder(TreeNode node) {
        if (node == null)
            return;

        // Traverse root
        System.out.print(node.val + "->");
        // Traverse left
        preorder(node.left);
        // Traverse right
        preorder(node.right);
    }

    public static void main(String[] args) {
        /*MergeTrees tree = new MergeTrees();
        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(3);
        tree.root1.right = new TreeNode(2);
        tree.root1.right.left = new TreeNode(4);
        tree.root1.right.right = new TreeNode(5);

        tree.root2 = new TreeNode(1);
        tree.root2.left = new TreeNode(3);
        tree.root2.right = new TreeNode(2);
        tree.root2.right.left = new TreeNode(4);
        tree.root2.right.right = new TreeNode(5);*/

        MergeTrees tree = new MergeTrees();
        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(3);
        tree.root1.left.left = new TreeNode(5);

        tree.root1.right = new TreeNode(2);

        tree.root2 = new TreeNode(2);
        tree.root2.left = new TreeNode(1);
        tree.root2.left.right = new TreeNode(4);
        tree.root2.right = new TreeNode(3);
        tree.root2.right.right = new TreeNode(7);

        mergeTrees(root1, root2);

        System.out.println("\nPreorder traversal ");
        tree.preorder(tree.root1);
    }
}
