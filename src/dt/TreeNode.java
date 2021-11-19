package dt;

import static dt.Printer.println;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.valueOf(data);
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        println(n.data);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNode n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) Printer.print("  ");
        if (isLeft)
            Printer.println("/- " + n.data);
        else
            Printer.println("\\- " + n.data);
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

}
