package chapter3.exercise13;

import dt.TreeNode;

public class Exercise13_1 {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode node) {
        findErrorRecursive(node);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void findErrorRecursive(TreeNode node) {
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
