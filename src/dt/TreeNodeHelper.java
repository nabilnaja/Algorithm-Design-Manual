package dt;

import java.util.ArrayList;
import java.util.List;

import static dt.Printer.println;

public class TreeNodeHelper<T> {

    public TreeNodeHelper() {
    }

    public TreeNode<T> arrayToTree(T[] values) {
        return arrayToTree(values, 0);
    }

    private TreeNode<T> arrayToTree(T[] values, int i) {
        if (i >= values.length) return null;
        return new TreeNode<>(values[i], arrayToTree(values, 2 * i + 1),
                arrayToTree(values, 2 * i + 2));
    }

    public TreeNode<T> sortedArrayToBST(T[] arr, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode<T> node = new TreeNode<>(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public List<T> bstToArray(TreeNode<T> n) {
        List<T> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(bstToArray(n.left));
        }
        result.add(n.val);

        if (n.right != null) {
            result.addAll(bstToArray(n.right));
        }
        return result;
    }

    public void printTree(TreeNode<T> n) {
        if (n == null) return;
        println(n.val);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private void printTree(TreeNode<T> n, int level, boolean isLeft) {
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
