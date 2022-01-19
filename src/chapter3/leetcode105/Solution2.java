package chapter3.leetcode105;

import dt.TreeNode;

class Solution2 {
    int index = 0;

    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTree(inorder, preorder, 0, inorder.length - 1);

    }

    private TreeNode<Integer> buildTree(int in[], int pre[], int inStrt, int inEnd){
        if (inStrt > inEnd)
            return null;


        TreeNode<Integer> tNode = new TreeNode<>(pre[index++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex  = getPos(in, inStrt, inEnd, tNode.val);

        tNode.left = buildTree(in, pre, inStrt, inIndex  - 1);
        tNode.right = buildTree(in, pre, inIndex  + 1, inEnd);

        return tNode;
    }
    int getPos(int[] arr, int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

}