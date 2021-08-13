package stack;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//with stack
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null ||!stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                current = node.right;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        /*root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);*/
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(inorderTraversal(root));
    }
}
