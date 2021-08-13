package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalRec {
    static List<Integer> list = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
       if (root == null) return list;
       preOrder(root);
       return list;
    }

    static void preOrder(TreeNode root) {
        if (root == null) {return;}
        else {
            System.out.println("NOTHING");
        }
        list.add(root.val);

        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        preOrder(root);

        System.out.println(list);
    }
}
