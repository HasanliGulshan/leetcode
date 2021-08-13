package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveLeafNodes {
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root, prev = null;

        while (curr != null || !deque.isEmpty()) {

            if (curr != null) {
                deque.addFirst(curr);
                curr = curr.left;
            } else {

                TreeNode x = deque.peekFirst();
                if (x.right != null && prev != x.right) {
                    curr = x.right;
                } else {
                    curr = deque.removeFirst();
                    prev = curr;

                    if (curr.val == target) {

                        if (!deque.isEmpty() && deque.peekFirst().left == curr) {
                            deque.peekFirst().left = null;
                        } else if (!deque.isEmpty() && deque.peekFirst().right == curr) {
                            deque.peekFirst().right = null;
                        }
                    }

                }
            }
        }

            return root;
        }

        public static boolean isLeaf (TreeNode node){
            return node.left == null && node.right == null;
        }

        public static void main (String[]args){
            TreeNode root = new TreeNode(2);
            //root.left = new TreeNode(3);
            //   root.left.left = new TreeNode(6);
            root.right = new TreeNode(2);

            root.right.left = new TreeNode(2);
            root.right.right = new TreeNode(2);
            root.right.right.right = new TreeNode(2);
            root.right.left.right = new TreeNode(10);
            root.right.left.left = new TreeNode(8);
            root.right.left.left.right = new TreeNode(2);

            removeLeafNodes(root, 2);
            inOrderTraversal(root);
        }

        static void inOrderTraversal (TreeNode root){
            if (root == null) return;

            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
