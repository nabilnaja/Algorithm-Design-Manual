package dt;

import java.util.ArrayList;
import java.util.List;

import static dt.Printer.println;
// todo use generics
public class TreeNodeString {

    public String val;
    public TreeNodeString left;
    public TreeNodeString right;

    public TreeNodeString() {
    }


    public TreeNodeString(String data) {
        this.val = data;
    }

    public TreeNodeString(String data, TreeNodeString left, TreeNodeString right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return val;
    }

    public static TreeNodeString arrayToTree(String[] values) {
        return arrayToTree(values, 0);
    }

    private static TreeNodeString arrayToTree(String[] values, int i) {
        if (i >= values.length) return null;
        return new TreeNodeString(values[i], arrayToTree(values, 2 * i + 1),
                arrayToTree(values, 2 * i + 2));
    }

    public static TreeNodeString sortedArrayToBST(String[] arr, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNodeString node = new TreeNodeString(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = TreeNodeString.sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public static void inOrder(TreeNodeString root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }


    public static List<String> bstToArray(TreeNodeString n) {
        List<String> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(bstToArray(n.left));
        }
        result.add(n.val);

        if (n.right != null) {
            result.addAll(bstToArray(n.right));
        }
        return result;
    }

    public static void printTree(TreeNodeString n) {
        if (n == null) return;
        println(n.val);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNodeString n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) Printer.print("  ");
        if (isLeft)
            Printer.println("/- " + n.val);
        else
            Printer.println("\\- " + n.val);
        printTree(n.left, level + 1, true);
        printTree(n.right, level + 1, false);
    }
}