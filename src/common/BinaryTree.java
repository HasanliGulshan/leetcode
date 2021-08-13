package common;

public class BinaryTree {
    public int val;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree() {
    }

    public BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree(int val, BinaryTree left, BinaryTree right, BinaryTree parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
