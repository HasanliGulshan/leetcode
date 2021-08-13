package binary_search;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindKLargestlnBST {
    public static List<Integer> findKLargestlnBST(TreeNode tree, int k){
        List<Integer> kLargestElements = new ArrayList<>();
        findKLargestlnBSTHelper(tree , k, kLargestElements);
        System.out.println(kLargestElements);
        return kLargestElements;
    }

    private static void findKLargestlnBSTHelper(TreeNode tree, int k, List<Integer> kLargestElements) {
         // Perform reverse inorder traversal .
        if (tree != null && kLargestElements.size() < k){

            findKLargestlnBSTHelper(tree.right , k, kLargestElements);
            if (kLargestElements.size() < k) {
                kLargestElements.add(tree.val);
                findKLargestlnBSTHelper(tree.left , k, kLargestElements);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(3);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(5);
        node.right = new TreeNode(7);

        findKLargestlnBST(node, 2);
    }
}
