package tree;

import common.TreeNode;

public class BalancedTree {
    static TreeNode root;

    public static boolean isBalanced(TreeNode root) {
          if (root == null) return true;

          return getHeight(root) != -1;
    }

    static int getHeight(TreeNode root) {
        if (root == null) return 0;

        int lH = getHeight(root.left);
        int rH = getHeight(root.right);

        if (lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
            System.out.println("l " + lH + " r " + rH + "  " + Math.abs(lH - rH));
            return -1;
        }
       /* System.out.println("LH : " + lH);
        System.out.println("RH : " + rH);
*/
       return Math.max(lH, rH) + 1;
    }
    public static void main(String[] args) {
       /* root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.right.left = new TreeNode(40);
        root.left.left = new TreeNode(60);

        root.right.left.left = new TreeNode(80);
        root.left.left.left = new TreeNode(100);

        System.out.println(isBalanced(root));
    }
}
