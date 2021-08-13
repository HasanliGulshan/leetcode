package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        increaseInOrder(root, values);

        TreeNode ans = new TreeNode(), cur = ans;

        for (int v : values) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public static List<Integer> increaseInOrder(TreeNode root, List<Integer> values) {
        if (root == null) return values;

        increaseInOrder(root.left, values);
        values.add(root.val);
        increaseInOrder(root.right, values);

        return values;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);

        root.left.right.left = new TreeNode(6);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        TreeNode res = increasingBST(root);
    }
}
