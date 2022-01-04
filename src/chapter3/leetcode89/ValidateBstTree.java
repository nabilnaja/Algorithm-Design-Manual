package chapter3.leetcode89;

import dt.TreeNode;

public class ValidateBstTree {
    TreeNode<Integer> prev;

    public boolean isValidBST(TreeNode<Integer> root) {
        prev =  null;
        return isValidBSTUtil(root);

    }

    public boolean isValidBSTUtil(TreeNode<Integer> root) {
        if (root != null){
            if (!isValidBSTUtil(root.left))
                return false;
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            return isValidBSTUtil(root.right);
        }
        return true;
    }
}
