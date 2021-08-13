/*
package tree;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class NAryPostorder {

    static Node root;
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();

        if (root == null) return ans;

       Deque<Node> deque = new ArrayDeque<>();
       deque.addFirst(root);

        while (!deque.isEmpty()) {
            Node node = deque.removeLast();

            ans.addFirst(node.val);

            if (node.children != null) {
                for (Node c : node.children) {
                    if (c != null)
                        deque.addLast(c);
                }
            }

        }

        System.out.println(ans);
        return ans;
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

        System.out.println(postorder(root));
    }
}
*/
