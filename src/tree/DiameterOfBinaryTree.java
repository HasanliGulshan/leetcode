package tree;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import common.ListNode;
import common.TreeNode;

public class DiameterOfBinaryTree {
    static TreeNode root;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        return getDiameter(root);
    }

    static int getDiameter(TreeNode node) {
        if (node == null) return 0;

        int lH = getHeight(node.left);
        int rH = getHeight(node.right);

        int lDiameter = getDiameter(node.left);
        int rDiameter = getDiameter(node.right);

        //first param for TreeNode with root path
        //second param for TreeNode without root path
        return Math.max((lH + rH + 1), Math.max(lDiameter, rDiameter));
    }

    static int getHeight(TreeNode node) {
        if (node == null) return 0;

        int lH = getHeight(node.left);
        int rH = getHeight(node.right);

        return Math.max(lH, rH) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);

        System.out.println(getDiameter(root));
    }
}
