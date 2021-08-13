/*
package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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


class NArrPreorder {

   static Node root;
    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            Node node = deque.removeLast();

            ans.add(node.val);

            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0 ; i--) {
                    deque.addLast(node.children.get(i));
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
        Node ch3 = new Node(4);

        List<Node> list = new ArrayList<>();
        list.add(ch1);
list.add(ch2);
list.add(ch3);

        root = new Node(1, list);

        System.out.println(preorder(root));
    }
}
*/
