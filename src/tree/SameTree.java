package tree;

import common.TreeNode;

public class SameTree {
    static TreeNode p;
    static TreeNode q;
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        //p.val and q.val belongs two conditions above and else return false
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }

    public static void main(String[] args) {

       /* p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);*/

      p = new TreeNode(1);
      p.left = new TreeNode(2);

      q = new TreeNode(1);
      q.left = null;
      q.right = new TreeNode(2);

        System.out.println(isSameTree(p,q));
    }
}
