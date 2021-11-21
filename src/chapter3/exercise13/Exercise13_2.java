package chapter3.exercise13;

import dt.TreeNode;

public class Exercise13_2 {
    TreeNode previous = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left == null) {
                checkError(root);
                previous = root;
                root = root.right;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null
                        && temp.right != root)
                    temp = temp.right;

                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    checkError(root);
                    previous = root;
                    root = root.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void checkError(TreeNode root) {
        if (previous.val > root.val) {
            if (first == null) {
                first = previous;
            }
            second = root;
        }
    }
}
