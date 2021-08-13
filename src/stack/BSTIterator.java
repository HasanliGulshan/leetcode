package stack;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    static Deque<Integer> deque;

    public BSTIterator(TreeNode root) {
       deque = new ArrayDeque<>();
       inOrder(root);
    }

    public static int next() {
       return deque.removeLast();
    }

    public static boolean hasNext() {
       return !deque.isEmpty();
    }

    static TreeNode root;

    public static void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        deque.addFirst(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(hasNext());
    }
}
