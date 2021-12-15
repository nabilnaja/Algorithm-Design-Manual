package chapter3.exercise13;

import dt.TreeNode;

public class Exercise13_1 {
    TreeNode<Integer> first = null;
    TreeNode<Integer> second = null;
    TreeNode<Integer> previous = new TreeNode<>(Integer.MIN_VALUE);

    public void recoverTree(TreeNode<Integer> node) {
        findErrorRecursive(node);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void findErrorRecursive(TreeNode<Integer> node) {
        if (node == null) return;
        findErrorRecursive(node.left);
        if (previous.val > node.val) {
            if (first == null) {
                first = previous;
            }
            second = node;
        }
        previous = node;
        findErrorRecursive(node.right);
    }
}
