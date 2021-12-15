package chapter3.exercise21;

import dt.TreeNode;

public class Exercise21 {


    public static TreeNode<Integer> concat(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        TreeNode<Integer> min = findMin(root2, null);
        min.left = root1;
        min.right = root2;
        return min;
    }

    private static TreeNode<Integer> findMin(TreeNode<Integer> root, TreeNode<Integer> prev){
        if (root.left == null)
        {
            if (prev != null)
                prev.left = null;
            return root;
        }
        return findMin(root.left, root);
    }
}
