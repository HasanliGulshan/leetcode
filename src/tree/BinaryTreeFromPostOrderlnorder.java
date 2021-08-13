package tree;

import common.TreeNode;

import java.util.HashMap;

public class BinaryTreeFromPostOrderlnorder {

    static HashMap<Integer, Integer> map;
    static int postIndex ;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
       map = new HashMap<>();
       postIndex = postorder.length-1;

       for (int i = 0; i < inorder.length; i++) {
           map.put(inorder[i], i);
       }

       return buildTreeFromPostOrderlnorderHelper(postorder, 0, postorder.length - 1);
    }

    //in postOrder root begins from end of arr
    public static TreeNode buildTreeFromPostOrderlnorderHelper(int[] postOrder, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = postOrder[postIndex--];
        TreeNode root = new TreeNode(val);

        root.right = buildTreeFromPostOrderlnorderHelper(postOrder,map.get(val)+1,right);
        root.left = buildTreeFromPostOrderlnorderHelper(postOrder,left,map.get(val)-1);

        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = new int[] {9,3,15,20,7};
        int[] postOrder = new int[] {9,15,7,20,3};

        TreeNode root = buildTree(inOrder, postOrder);

        levelOrder(root);
    }

    static void levelOrder(TreeNode root) {
        System.out.print(root.val + " ");

        if (root.left != null) {
            levelOrder( root.left);
        }

        if (root.right != null) {
            levelOrder(root.right);
        }
    }
}
