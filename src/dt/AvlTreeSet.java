package dt;

public class AvlTreeSet<T extends Comparable<T>> extends AvlTreeAbstract<T> {

    @Override
    public AvlTreeNode<T> insert(AvlTreeNode<T> node, T data) {
        if (node == null)
            return new AvlTreeNode<>(data);
        int cmp = node.val.compareTo(data);
        if (cmp > 0) {
            node.biggerThan++;
            node.left = insert(node.left, data);
        } else if (cmp < 0) {
            node.right = insert(node.right, data);
        } else {
            node.frequency++;
        }
        return rebalance(node);
    }

    @Override
    public AvlTreeNode<T> delete(AvlTreeNode<T> node, T data) {
        if (node == null)
            return null;

        int cmp = node.val.compareTo(data);
        if (cmp > 0) {
            node.left = delete(node.left, data);
        } else if (cmp < 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                AvlTreeNode<T> mostLeftChild = mostLeftChild(node.right);
                node.val = mostLeftChild.val;
                node.right = delete(node.right, node.val);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    @Override
    public AvlTreeNode<T> insertAt(T data, int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AvlTreeNode<T> deleteAt(T data, int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String printNode(AvlTreeNode<T> node) {
        return "val : " + node.val + " bigger than : " + node.biggerThan + " frequency : " + node.frequency;
    }

    @Override
    protected void updatePropertiesLeft(AvlTreeNode<T> y, AvlTreeNode<T> x) {
        x.biggerThan = x.biggerThan + y.biggerThan + y.frequency;
    }

    @Override
    protected void updatePropertiesRight(AvlTreeNode<T> y, AvlTreeNode<T> x) {
        y.biggerThan = y.biggerThan - x.biggerThan - x.frequency;
    }

    @Override
    public AvlTreeNode<T> find(T key) {
        AvlTreeNode<T> current = root;
        while (current != null) {
            if (current.val == key) {
                break;
            }
            int cmp = current.val.compareTo(key);
            current = cmp < 0 ? current.right : current.left;
        }
        return current;
    }

    @Override
    public AvlTreeNode<T> findAt(int index) {
        throw new UnsupportedOperationException();
    }


}
