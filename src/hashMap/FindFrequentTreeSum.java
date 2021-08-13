package hashMap;

import common.TreeNode;

import java.util.*;

public class FindFrequentTreeSum {
    public static int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        getSubTreeSums(root, sums);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int sum : sums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> ans = new ArrayList<>();

        int maxOccurrence = list.get(0).getValue();
        for (Map.Entry<Integer, Integer> m : list) {
            if (maxOccurrence == m.getValue()) {
                ans.add(m.getKey());
            }
        }

        System.out.println(ans);
        int[] res = ans.stream().mapToInt(Integer::intValue).toArray();


        return res;
    }

    public static int getSubTreeSums(TreeNode root, List<Integer> list) {
        if (root == null) return 0;

        int left = getSubTreeSums(root.left, list);
        int right = getSubTreeSums(root.right, list);

        int currSum = left + right + root.val;
        list.add(currSum);

        return currSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        findFrequentTreeSum(root);
    }
}
