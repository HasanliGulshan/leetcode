package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalRec {
    static List<Integer> list = new ArrayList<>();

    public static List <Integer> inorderTraversal(TreeNode root) {
           if (root == null) return list;
           inOrderTraversal(root);

           return list;
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null) return ;

        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        inorderTraversal(root);

        System.out.println(list);
    }
}
