package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    static TreeNode root;
    static int minDepth = 0;

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.right == null && node.left == null)
                        return minDepth;

                if (node.right != null)
                    queue.add(node.right);

                if (node.left != null)
                    queue.add(node.left);

            }
        }
        return minDepth;
    }

        public static void main (String[]args){
            root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);

            root.right.left = new TreeNode(15);
            root.right.left = new TreeNode(7);

       /* root = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);*/

            System.out.println(minDepth(root));
        }
    }
