package chapter3.exercise17;

import dt.TreeNode;

public class Exercise17 {

    public boolean isBalanced(TreeNode root) {
        return balanced(root) != Integer.MIN_VALUE;
    }

    public int balanced(TreeNode root) {
        if (root == null) return -1;
        int lh = balanced(root.left);
        if (lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rh = balanced(root.right);
        if (rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Math.abs(lh - rh) <= 1 ? 1 + Math.max(lh, rh) : Integer.MIN_VALUE;
    }
}
