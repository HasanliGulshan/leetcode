package stack;

import java.util.Stack;

public class RemoveDuplicatesLetter {

    class Node{
        char c;
        int times;

        Node(char c) {
            this.c = c;
            times = 1;
        }
    }

    public  String removeDuplicates(String s, int k) {
        if (s.length() < k) return s;

        Stack<Node> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek().c) {

                Node node = stack.peek();
                int times = node.times;

                if (times + 1 == k) {
                    stack.pop();
                } else {
                    node.times = node.times + 1;
                }
            } else {
                stack.push(new Node(c));
            }
        }

        if (stack.size() == 0) return "";

        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            while (node.times > 0) {
                builder.append(node.c);
                node.times--;
            }
        }

        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        RemoveDuplicatesLetter r = new RemoveDuplicatesLetter();
        String s = "aaaasssss";
        System.out.println(r.removeDuplicates(s, 2));
    }
}
