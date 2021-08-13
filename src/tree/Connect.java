package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Connect {
    public static Node connect(Node root) {
        if (root == null) return null;

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            Node child1 = deque.removeLast();
            int size = deque.size();

            if (child1.left != null)
                deque.addFirst(child1.left);

            if (child1.right != null) {
                deque.addFirst(child1.right);
            }

            for (int i = 1; i <= size; i++) {
                Node child2 = deque.removeLast();

                if (!isLeaf(child2)) {

                    deque.addFirst(child2.left);
                    deque.addFirst(child2.right);

                }
                child1.next = child2;
                child1 = child2;
            }

            child1.next = null;

        }

        return root;
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);
        root.right.left = new Node(6);


        Node ans = connect(root);
    }
}
