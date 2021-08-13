package tree;

import common.ListNode;
import common.TreeNode;

public class SubPath {
    static boolean leftSubPath = false;
    static boolean rightSubPath = false;

    public static boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) {
            if (head == null)
                return true;

            return false;
        }

        return checkSubPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static boolean checkSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return root.val == head.val && (checkSubPath(head.next, root.left) || checkSubPath(head.next, root.right));
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);


        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);*/

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);


        root.right.left.right = new TreeNode(8);
        root.left.right.left.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(3);

        System.out.println(isSubPath(head, root));
    }
}
