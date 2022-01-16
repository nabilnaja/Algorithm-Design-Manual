package dt;

public class AvlTreeNode<T extends Comparable<T>> {
    public T val;
    int height;
    int size;
    int frequency;
    public AvlTreeNode<T> left;
    public AvlTreeNode<T> right;

    public AvlTreeNode(T val){
        this.val = val;
        height = 1;
        size = 1;
        frequency = 0;
    }

}
