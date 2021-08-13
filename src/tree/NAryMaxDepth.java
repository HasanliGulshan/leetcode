package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NAryMaxDepth {
    static Node root;

    public static int maxDepth(Node root) {

        return getMaxHeight(root);
    }

    static int getMaxHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        if (root.children != null) {
            for (Node n : root.children) {

                max = Math.max(getMaxHeight(n), max);

            }
        }


        return max + 1;
    }

    public static void main(String[] args) {
        List<Node> ch33 = new ArrayList<>();

        Node ch11 = new Node(5);
        Node ch12 = new Node(6);

        ch33.add(ch11);
        ch33.add(ch12);

        Node ch1 = new Node(3, ch33);

        Node ch2 = new Node(2);


        List<Node> lc = new ArrayList<>();

        lc.add(new Node(44));
        lc.add(new Node(55));

        Node ch3 = new Node(4, lc);

        List<Node> list = new ArrayList<>();
        list.add(ch1);
        list.add(ch2);
        list.add(ch3);

        root = new Node(1, list);

        System.out.println(maxDepth(root));
    }
}
*/
