package dt;

public class AvlTree<T extends Comparable<T>> {

    public AvlTreeNode<T> root;

    protected int getHeight(AvlTreeNode<T> node) {
        return node == null ? 0 : node.height;
    }

    protected void updateHeight(AvlTreeNode<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    protected int getBalance(AvlTreeNode<T> n) {
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
        y.biggerThan = y.biggerThan - x.biggerThan - x.frequency;
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
        x.biggerThan = x.biggerThan + y.biggerThan + y.frequency;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    protected AvlTreeNode<T> rebalance(AvlTreeNode<T> node) {
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

    protected AvlTreeNode<T> mostLeftChild(AvlTreeNode<T> node) {
        AvlTreeNode<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

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

    public void preOrder(AvlTreeNode<T> node) {
        if (node != null) {
            System.out.print(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(AvlTreeNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val + " " + node.biggerThan + " " + node.frequency);
            inOrder(node.right);
        }
    }

    public boolean balancedIntern() {
        return balanced(root) != Integer.MIN_VALUE;
    }

    public int balanced(AvlTreeNode<T> root) {
        if (root == null) return -1;
        int lh = balanced(root.left);
        if (lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rh = balanced(root.right);
        if (rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Math.abs(lh - rh) <= 1 ? 1 + Math.max(lh, rh) : Integer.MIN_VALUE;
    }

}
