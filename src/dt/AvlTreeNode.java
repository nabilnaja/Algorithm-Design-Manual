package dt;

public class AvlTreeNode<T extends Comparable<T>> {
    T val;
    int height;
    int size;
    AvlTreeNode<T> left;
    AvlTreeNode<T> right;

    public AvlTreeNode(T val){
        this.val = val;
        height = 1;
        size = 1;
    }

}
