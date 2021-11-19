package chapter3.exercise12;

import dt.TreeNode;

public class Exercise12 {

    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int a = maxDepth(root.right) + 1;
        int b = maxDepth(root.left) + 1;
        return Math.max(a, b);
    }

}
