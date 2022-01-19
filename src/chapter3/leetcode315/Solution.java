package chapter3.leetcode315;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        AvlTree avlTree = new AvlTree();
        int n = nums.length - 1;
        avlTree.root = avlTree.insert(avlTree.root, nums[n--], 0);
        res.add(0);

        for (int i = n ; i >= 0; i--) {
            avlTree.root = avlTree.insert(avlTree.root, nums[i], 0);
            res.add(0, avlTree.total);
            avlTree.total = 0;
        }
        return res;
    }

    public class AvlTreeNode{
        public int val;
        int height;
        public int frequency;
        public int biggerThan;
        public AvlTreeNode left;
        public AvlTreeNode right;

        public AvlTreeNode(int val){
            this.val = val;
            height = 1;
            frequency = 1;
            biggerThan = 0;
        }

    }

    public class AvlTree{
        public int total = 0;
        public AvlTreeNode root;

        private int getHeight(AvlTreeNode node) {
            return node == null ? 0  : node.height;
        }

        public void updateHeight(AvlTreeNode node) {
            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        private int getBalance(AvlTreeNode n) {
            return n == null ? 0 : getHeight(n.right) - getHeight(n.left);
        }

        AvlTreeNode rotateRight(AvlTreeNode y) {
            AvlTreeNode x = y.left;
            AvlTreeNode z = x.right;
            x.right = y;
            y.left = z;
            y.biggerThan = y.biggerThan - x.biggerThan - x.frequency;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        AvlTreeNode rotateLeft(AvlTreeNode y) {
            AvlTreeNode x = y.right;
            AvlTreeNode z = x.left;
            x.left = y;
            y.right = z;
            x.biggerThan = x.biggerThan + y.biggerThan + y.frequency;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        AvlTreeNode rebalance(AvlTreeNode node) {
            updateHeight(node);
            int balance = getBalance(node);
            if (balance > 1) {
                if (getHeight(node.right.right) > getHeight(node.right.left)) {
                    node = rotateLeft(node);
                } else {
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            } else if (balance < -1) {
                if (getHeight(node.left.left) > getHeight(node.left.right))
                    node = rotateRight(node);
                else {
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            }
            return node;
        }

        public AvlTreeNode insert(AvlTreeNode node, int data, int count) {
            if (node == null){
                total = count;
                return new AvlTreeNode(data);
            }
            if (node.val > data) {
                node.biggerThan++;
                node.left = insert(node.left, data, count);
            } else if (node.val < data) {
                count +=  node.biggerThan + node.frequency;
                node.right = insert(node.right, data,count);
            } else {
                node.frequency++;
                total = count + node.biggerThan;
            }
            return rebalance(node);
        }

    }


}