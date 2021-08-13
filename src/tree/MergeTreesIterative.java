package tree;

import common.TreeNode;

import java.util.Stack;

public class MergeTreesIterative {
    static TreeNode root1;
    static TreeNode root2;

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        // Create an empty stack and push root to it
        Stack<TreeNode[] > nodeStack = new Stack<>();
        nodeStack.push(new TreeNode[]{root1, root2});

        while (!nodeStack.empty()) {
            TreeNode[] t = nodeStack.pop();

            if (t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            // Push right and left children of the popped node to stack
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                nodeStack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
               t[0].right = t[1].right;
            } else {
                nodeStack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
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
        MergeTreesIterative tree = new MergeTreesIterative();
        tree.root1 = new TreeNode(1);
        tree.root1.left = new TreeNode(3);
        tree.root1.right = new TreeNode(2);
        tree.root1.right.left = new TreeNode(4);
        tree.root1.right.right = new TreeNode(5);

        tree.root2 = new TreeNode(1);
        tree.root2.left = new TreeNode(3);
        tree.root2.right = new TreeNode(2);
        tree.root2.right.left = new TreeNode(4);
        tree.root2.right.right = new TreeNode(5);

        mergeTrees(root1, root2);

        System.out.println("\nPreorder traversal ");
        tree.preorder(tree.root1);
    }
}
