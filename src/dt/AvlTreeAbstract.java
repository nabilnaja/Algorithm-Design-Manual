package dt;

public abstract class AvlTreeAbstract<T extends Comparable<T>> {

    public AvlTreeNode<T> root;

    abstract protected void updatePropertiesLeft(AvlTreeNode<T> y, AvlTreeNode<T> x);
    abstract protected void updatePropertiesRight(AvlTreeNode<T> y, AvlTreeNode<T> x);

    abstract public AvlTreeNode<T> find(T key);

    abstract public AvlTreeNode<T> findAt(int index);

    abstract public AvlTreeNode<T> insert(AvlTreeNode<T> node, T data);

    abstract public AvlTreeNode<T> delete(AvlTreeNode<T> node, T data);

    abstract public AvlTreeNode<T> insertAt(T data, int index);

    abstract public AvlTreeNode<T> deleteAt(T data, int index);

    final protected int getHeight(AvlTreeNode<T> node) {
        return node == null ? 0 : node.height;
    }

    final protected void updateHeight(AvlTreeNode<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    final protected int getBalance(AvlTreeNode<T> n) {
        return n == null ? 0 : getHeight(n.right) - getHeight(n.left);
    }


    //          y                                   x
    //      x                   ->                      y
    //          z                                   z
    protected AvlTreeNode<T> rotateRight(AvlTreeNode<T> y) {
        AvlTreeNode<T> x = y.left;
        AvlTreeNode<T> z = x.right;
        x.right = y;
        y.left = z;
        updatePropertiesRight(y, x);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    //          y                                   x
    //               x          ->             y
    //          z                                   z
    protected AvlTreeNode<T> rotateLeft(AvlTreeNode<T> y) {
        AvlTreeNode<T> x = y.right;
        AvlTreeNode<T> z = x.left;
        x.left = y;
        y.right = z;
        updatePropertiesLeft(y, x);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    final protected AvlTreeNode<T> rebalance(AvlTreeNode<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (getHeight(node.right.right) > getHeight(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (getHeight(node.left.left) > getHeight(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    final protected AvlTreeNode<T> mostLeftChild(AvlTreeNode<T> node) {
        AvlTreeNode<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    final public void preOrder(AvlTreeNode<T> node) {
        if (node != null) {
            System.out.println(printNode(node));
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    final public void inOrder(AvlTreeNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(printNode(node));
            inOrder(node.right);
        }
    }

    abstract public String printNode(AvlTreeNode<T> node);

    final public boolean balancedIntern() {
        return balanced(root) != Integer.MIN_VALUE;
    }

    final public int balanced(AvlTreeNode<T> root) {
        if (root == null) return -1;
        int lh = balanced(root.left);
        if (lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rh = balanced(root.right);
        if (rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Math.abs(lh - rh) <= 1 ? 1 + Math.max(lh, rh) : Integer.MIN_VALUE;
    }

}
