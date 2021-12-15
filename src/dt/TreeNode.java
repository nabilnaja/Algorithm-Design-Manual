package dt;

public class TreeNode<T> {

    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }


    public TreeNode(T data) {
        this.val = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.valueOf(val);
    }


}
