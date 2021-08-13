package binary_search;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Interval {
    public int left, right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class RangeLookupInBST {

    public static List<Integer> rangeLookupInBST(TreeNode tree,
                                                 Interval interval) {
        List<Integer> result = new ArrayList<>();
        rangeLookupInBSTHelper(tree, interval, result);
        return result;
    }

    public static void rangeLookupInBSTHelper(TreeNode tree, Interval interval, List<Integer> result) {
        if (tree == null) {
            return;
        }

        if (interval.left <= tree.val && tree.val <= interval.right) {
            // tree.data lies in the interval.
            rangeLookupInBSTHelper(tree.left, interval, result);
            result.add(tree.val);
            rangeLookupInBSTHelper(tree.right, interval, result);
        } else if (interval.left > tree.val) {
            rangeLookupInBSTHelper(tree.right, interval, result);
        } else { // interval.right >= tree.data
            rangeLookupInBSTHelper(tree.left, interval, result);
        }
    }
}
