package tree;

import common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumEvenGrandparent {
    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();

        if (root.val % 2 == 0) {
            deque.addFirst(new Pair(root, 1));
        } else {
            deque.addFirst(new Pair(root, 0));
        }
        int sum = 0;

        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> p = deque.removeFirst();
            TreeNode node = p.getKey();
            int status = p.getValue();

            if (status == 2 || status == 3) {
                if (node.right != null)
                    sum += node.right.val;

                if (node.left != null)
                    sum += node.left.val;
            }

            if (node.right != null) {
                if (node.right.val % 2 == 0) {

                    if (status == 0 || status == 2) {
                        status = 1;
                    } else if (status == 1) {
                        status = 3;
                    }

                    deque.addFirst(new Pair(node.right, status));
                } else {

                    if (status == 1 || status == 3) {
                        status = 2;
                    } else {
                        status = 0;
                    }
                    deque.addFirst(new Pair(node.right, status));
                }
            }
            status = p.getValue();
            if (node.left != null) {
                if (node.left.val % 2 == 0) {
                    if (status == 0 || status == 2) {
                        status = 1;
                    } else if (status == 1) {
                        status = 3;
                    }

                    deque.addFirst(new Pair(node.left, status));
                } else {
                    if (status == 1 || status == 3) {
                        status = 2;
                    } else {
                        status = 0;
                    }
                    deque.addFirst(new Pair(node.left, status));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(7);

        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        System.out.println(sumEvenGrandparent(root));
    }
}
