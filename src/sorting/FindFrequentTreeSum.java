package sorting;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum {
    static int maxOccurrence = 0;
    static HashMap<Integer, Integer> map = null;

    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        map = new HashMap<>();

        getSubTreeSums(root, map);


        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (maxOccurrence == m.getValue()) {
                list.add(m.getKey());
            }
        }

        System.out.println(list);
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();


        return res;
    }

    public static int getSubTreeSums(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;

        int left = getSubTreeSums(root.left, map);
        int right = getSubTreeSums(root.right, map);

        int currSum = left + right + root.val;
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        maxOccurrence = Math.max(maxOccurrence, map.get(currSum));
        return currSum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);

        node.left = new TreeNode(2);
        /*node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);*/

        node.right = new TreeNode(-5);/*
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(8);*/

        findFrequentTreeSum(node);
    }
}
