package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    private int totalTilt = 0;

    protected int valueSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = this.valueSum(node.left);
        int rightSum = this.valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;

        // return the sum of values starting from this node.
        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        this.totalTilt = 0;
        this.valueSum(root);
        return this.totalTilt;

}*/
public class FindTilt {
    static TreeNode root;
    static int total = 0;
    public static int findTilt(TreeNode root) {
        postOrder(root);

        return total;
    }

    static int postOrder(TreeNode root){
        if(root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        total += Math.abs(left - right);

        return root.val + left + right;
    }

    public static void main(String[] args) {
        FindTilt tree = new FindTilt();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(9);
        tree.root.right.right = new TreeNode(7);

        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);

        System.out.println(findTilt(root));

    }
}
