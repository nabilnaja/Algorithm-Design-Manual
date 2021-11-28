package dt;

import java.util.ArrayList;
import java.util.List;

import static dt.Printer.println;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }


    public TreeNode(int data) {
        this.val = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        println(n.val);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNode n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) Printer.print("  ");
        if (isLeft)
            Printer.println("/- " + n.val);
        else
            Printer.println("\\- " + n.val);
        printTree(n.left, level + 1, true);
        printTree(n.right, level + 1, false);
    }

    public static TreeNode arrayToTree(int[] values) {
        return arrayToTree(values, 0);
    }

    private static TreeNode arrayToTree(int[] values, int i) {
        if (i >= values.length) return null;
        return new TreeNode(values[i], arrayToTree(values, 2 * i + 1),
                arrayToTree(values, 2 * i + 2));
    }

    public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
    public static void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }


    public static List<Integer> bstToArray(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(bstToArray(n.left));
        }
        result.add(n.val);

        if (n.right != null) {
            result.addAll(bstToArray(n.right));
        }
        return result;
    }
}
