package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromPreorderlnorder {
    public static TreeNode binaryTreeFromPreorderlnorder(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            nodeToInorderIdx.put(inorder[i], i);
        }
        return binaryTreeFromPreorderInorderHelper(preorder, 0, preorder.length, 0, inorder.length, nodeToInorderIdx);
    }

    // Builds the subtree with preorder . subList(preorderStart , preorderEnd) and
    // inorder.subList(inorderStart , inorderEnd).
    private static TreeNode binaryTreeFromPreorderInorderHelper(int[] preorder, int preorderStart, int preorderEnd,
                                                                int inorderStart, int inorderEnd, Map<Integer, Integer> nodeToInOrderLdx) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        int rootInOrderLdx = nodeToInOrderLdx.get(preorder[preorderStart]);
        int leftSubtreeSize = rootInOrderLdx - inorderStart;

        TreeNode node = new TreeNode(preorder[preorderStart]);

        node.left = binaryTreeFromPreorderInorderHelper(
                preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize,
                inorderStart, rootInOrderLdx, nodeToInOrderLdx);

        node.right =  binaryTreeFromPreorderInorderHelper(
                preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd,
                rootInOrderLdx + 1, inorderEnd, nodeToInOrderLdx);


        return node;
    }

    public static void main(String[] args) {
       int[] preOrder = new int[]{3,9,20,15,7};
       int[] inOrder = new int[]{9,3,15,20,7};


       TreeNode root = binaryTreeFromPreorderlnorder(preOrder, inOrder);
    }
}

