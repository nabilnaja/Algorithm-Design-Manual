package dt;

public class AvlTreeNode<T extends Comparable<T>> {
    public T val;
    public int biggerThan;
    int height;
    int size;
    int frequency;
    int sum;
    public AvlTreeNode<T> left;
    public AvlTreeNode<T> right;

    public AvlTreeNode(T val){
        this.val = val;
        height = 1;
        size = 1;
        biggerThan = 0;
        frequency = 1;
        sum = val instanceof Integer ? (Integer) val : 0;
    }

}
