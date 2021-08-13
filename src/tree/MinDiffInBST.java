package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinDiffInBST {
private static TreeNode root;
    private static int minDiff = Integer.MAX_VALUE;

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
       inOrderTraversal(root, list);

        System.out.println(list);
       for (int i = 0; i < list.size() - 1; i++) {
           minDiff = Math.min(minDiff, list.get(i+1) - list.get(i));
       }

       return minDiff;
    }

    static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);

    }

    public static void main(String[] args) {
      /*  MinDiffInBST tree = new MinDiffInBST();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(0);
        tree.root.right = new TreeNode(48);

        tree.root.right.left = new TreeNode(12);
        tree.root.right.right = new TreeNode(49);*/

        MinDiffInBST tree = new MinDiffInBST();
        tree.root = new TreeNode(71);
        tree.root.left = new TreeNode(62);
        tree.root.right = new TreeNode(84);

        tree.root.left.left = new TreeNode(14);
        tree.root.right.right = new TreeNode(88);

        System.out.println(minDiffInBST(root));
    }
}
