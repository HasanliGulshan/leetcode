package binary_search;

import common.TreeNode;

import java.util.*;

class QueueEntry {
    public TreeNode treeNode;
    public Integer lowerBound, upperBound;

    public QueueEntry(TreeNode treeNode, Integer lowerBound,
                      Integer upperBound) {
        this.treeNode = treeNode;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
}

public class IsBinaryTreeBST {

    public static boolean isValidBST(TreeNode tree) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curr = tree;
        while (curr != null || deque.size() > 0) {

            while (curr != null) {
                deque.addFirst(curr);
                curr = curr.left;
            }

            curr = deque.removeFirst();

            list.add(curr.val);
            curr = curr.right;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1) <= list.get(i)) return false;
        }

        return true;
    }
    /*public static boolean isBinaryTreeBST(TreeNode tree) {
        Deque<QueueEntry> BFSQueue = new ArrayDeque<>();
        BFSQueue.add(new QueueEntry(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
        QueueEntry headEntry;
        while ((headEntry = BFSQueue.poll()) != null) {
            if (headEntry.treeNode != null) {

                if (headEntry.treeNode.val < headEntry.lowerBound || headEntry.treeNode.val > headEntry.upperBound) {
                    return false;
                }

                BFSQueue.add(new QueueEntry(headEntry.treeNode.left,
                        headEntry.lowerBound,
                        headEntry.treeNode.val));

                BFSQueue.add(new QueueEntry(headEntry.treeNode.right,
                        headEntry.treeNode.val,
                        headEntry.upperBound));
            }
        }
        return true;
    }*/

    private static boolean areKeysInRange(TreeNode tree,
                                          Integer lower, Integer upper) {
        if (tree == null) {
            return true ;
        } else if (tree.val < lower || tree.val > upper) {
            return false;
        }
        return areKeysInRange(tree.left , lower, tree.val)
                && areKeysInRange(tree.right , tree.val, upper);
    }

    public static void main(String[] args) {
        /*TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);*/

        ///[-2147483648,null,2147483647]

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);

     //   node.left.left = new TreeNode(1);
        //node.left.right = new TreeNode(6);
        node.right = new TreeNode(4);
     /*   node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(6);*/

        System.out.println(isValidBST(node));
    }
}
