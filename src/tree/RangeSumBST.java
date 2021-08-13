package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> sumList = new ArrayList<>();
        int sum;

        preOrderRange(root, low, high, sumList);

        sum = sumList.stream().mapToInt(value -> value).sum();

        return sum;
    }

    public static List<Integer> preOrderRange(TreeNode root, int low, int high, List<Integer> list) {
        //when reach end of let or right just return list
        if (root == null) return list;

        if (root.val >= low && root.val <= high)
            list.add(root.val);

        preOrderRange(root.left, low, high, list);
        preOrderRange(root.right, low, high, list);

        //when iterated over binary tree finish with list
        return list;
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

        System.out.println(rangeSumBST(root, 6, 10));
    }
}
