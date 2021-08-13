package tree;

import common.TreeNode;

public class BinaryTreeFromPreorderlnorder2 {
    static int preIndex;

    public static TreeNode buildTreeFromInOrderPreOrder(int preorderArray[], int inorderArray[], int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = createNewNode(preorderArray[preIndex++]);

        if (start == end) {
            return node;
        }

        int inoderIndex = getInorderIndex(node.val, inorderArray, start, end);

        node.left = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, start, inoderIndex - 1);
        node.right = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, inoderIndex + 1, end);

        return node;
    }

    private static int getInorderIndex(int val, int in[], int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public static TreeNode createNewNode(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode();

        TreeNode root = null;
        int[] preorderArray = {3,9,20,15,7};
        int[] inorderArray = {9,3,15,20,7};

        root = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, 0, inorderArray.length - 1);
    }
}
