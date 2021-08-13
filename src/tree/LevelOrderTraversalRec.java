package tree;

import common.ListNode;
import common.TreeNode;

import java.util.*;

public class LevelOrderTraversalRec {

    static TreeNode root;

    //////////////////////////////??//////////////////////////////////
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            makeList(0, root, res);

            Collections.reverse(res);
        }
        return res;
    }

    static void makeList(int level, TreeNode root, List<List<Integer>> res) {
        if (root != null && level == res.size()) {
            res.add(new ArrayList<>());
        } else {
            System.out.println("ILK IF HECNE");
        }

        res.get(level).add(root.val);

        if (root.left != null) {
            makeList(level + 1, root.left, res);
        } else {
            System.out.println("ROOT LEFT NULL");
        }

        if (root.right != null) {
            makeList(level + 1, root.right, res);
        } else {
            System.out.println("ROOT RIGHT NULL");
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));
    }
}
