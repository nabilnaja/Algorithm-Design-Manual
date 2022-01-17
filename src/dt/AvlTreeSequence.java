package dt;

public class AvlTreeSequence<T extends Comparable<T>> extends AvlTreeAbstract<T> {

    public int size() {
        return root != null ? root.size : 0;
    }

    final protected int getSize(AvlTreeNode<T> node) {
        return node == null ? 0 : node.size;
    }

    final protected int getSum(AvlTreeNode<T> node) {
        return node == null ? 0 : node.sum;
    }

    @Override
    public AvlTreeNode<T> insert(AvlTreeNode<T> node, T data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AvlTreeNode<T> delete(AvlTreeNode<T> node, T data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AvlTreeNode<T> insertAt(T data, int index) {
        if (index != 0 && (index < 0 || index > size()))
            throw new IndexOutOfBoundsException();
        return insert(root, data, index);
    }

    public AvlTreeNode<T> insert(AvlTreeNode<T> node, T data, int index) {
        if (node == null)
            return new AvlTreeNode<>(data);
        int leftSize = getSize(node.left);
        if (index <= leftSize) {
            node.left = insert(node.left, data, index);
        } else {
            node.right = insert(node.right, data, index - leftSize - 1);
        }
        recalculate(node);
        return rebalance(node);
    }

    @Override
    public AvlTreeNode<T> deleteAt(T data, int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return null;
    }


    @Override
    protected void updatePropertiesLeft(AvlTreeNode<T> y, AvlTreeNode<T> x) {
        recalculate(y);
        recalculate(x);
    }

    @Override
    protected void updatePropertiesRight(AvlTreeNode<T> y, AvlTreeNode<T> x) {
        recalculate(y);
        recalculate(x);
    }

    private void
    recalculate(AvlTreeNode<T> node) {
        if (node != null) {
            node.size = getSize(node.left) + getSize(node.right) + 1;
            if (node.val instanceof Integer)
                node.sum = (Integer) node.val + getSum(node.left) + getSum(node.right);

        }
    }

    @Override
    public AvlTreeNode<T> find(T key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AvlTreeNode<T> findAt(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return getNodeAt(root, index);
    }
    Integer partialSum = 0;

    public Integer partialSum(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        partialSum = 0;
        partialSum(root, index);
        return partialSum;
    }

    public void partialSum(AvlTreeNode<T> node, int index) {
        int leftSize = getSize(node.left);
        if (index < leftSize) {
            partialSum(node.left, index);
        } else if (index > leftSize) {
            partialSum += node.sum - getSum(node.right);
            partialSum(node.right, index - leftSize - 1);
        } else {
            partialSum = partialSum + node.sum - getSum(node.right);
        }
    }

    private AvlTreeNode<T> getNodeAt(AvlTreeNode<T> node, int index) {
        int leftSize = getSize(node.left);
        if (index < leftSize)
            return getNodeAt(node.left, index);
        else if (index > leftSize)
            return getNodeAt(node.right, index - leftSize - 1);
        else
            return node;
    }

    @Override
    public String printNode(AvlTreeNode<T> node) {
        return "val : " + node.val + " size : " + node.size + " sum : " + node.sum;
    }


}
