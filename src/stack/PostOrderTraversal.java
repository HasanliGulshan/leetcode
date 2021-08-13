package stack;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//with stack
public class PostOrderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            list.add(0, node.val);

            if (node.left != null) stack.push(node.left);

            if (node.right != null) stack.push(node.right);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));
    }
}
