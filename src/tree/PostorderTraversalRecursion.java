package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversalRecursion {
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;

        postOrderTraversal(root);

        return list;
    }

    static void postOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.println("NOTHING");
        }

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        postorderTraversal(root);

        System.out.println(list);
    }
}
