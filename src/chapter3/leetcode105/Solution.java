package chapter3.leetcode105;

import dt.TreeNode;

import java.util.HashMap;

class Solution {
    HashMap<Integer,Integer> cache;
    int index;
    int cacheIndex;

    public Solution() {
    }

    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        index = 0;
        cacheIndex = 0;
        cache = new HashMap<>();
        return buildTree(inorder, preorder, 0, inorder.length - 1);

    }

    private TreeNode<Integer> buildTree(int[] inorder, int[] preorder, int inStrt, int inEnd){
        if (inStrt > inEnd)
            return null;


        TreeNode<Integer> tNode = new TreeNode<>(preorder[index++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex  = getPos(inorder, tNode.val);

        tNode.left = buildTree(inorder, preorder, inStrt, inIndex  - 1);
        tNode.right = buildTree(inorder, preorder, inIndex  + 1, inEnd);

        return tNode;
    }
    int getPos(int[] inorder, int value)
    {
        if (cache.containsKey(value))
            return cache.get(value);
        while (cacheIndex < inorder.length){
            cache.put(inorder[cacheIndex], cacheIndex);
            if (inorder[cacheIndex] == value){
                return cacheIndex++;
            }
            cacheIndex++;
        }
        return -1;
    }

}