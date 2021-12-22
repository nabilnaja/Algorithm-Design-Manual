package dt;

public class AvlTree<T extends Comparable<T>> {

    public AvlTreeNode<T> root;

    public void updateHeight(AvlTreeNode<T> n) {
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    private int getHeight(AvlTreeNode<T> n) {
        return n == null ? 0 : n.height;
    }

    private int getBalance(AvlTreeNode<T> n) {
        return n == null ? 0 : getHeight(n.right) - getHeight(n.left);
    }

    //          y                                   x
    //      x                   ->                      y
    //          z                                   z
    AvlTreeNode<T> rightRotate(AvlTreeNode<T> y) {
        AvlTreeNode<T> x = y.left;
        AvlTreeNode<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return x;
    }

    //          y                                   x
    //              x       ->                  y
    //          z                                   z
    AvlTreeNode<T> leftRotate(AvlTreeNode<T> x) {
        AvlTreeNode<T> y = x.right;
        AvlTreeNode<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        updateHeight(x);
        updateHeight(y);

        // Return new root
        return y;
    }

    AvlTreeNode<T> rebalance(AvlTreeNode<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (getHeight(node.right.right) > getHeight(node.right.left)) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        } else if (balance < -1) {
            if (getHeight(node.left.left) > getHeight(node.left.right))
                node = rightRotate(node);
            else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }
        return node;
    }

    public AvlTreeNode<T> insert(AvlTreeNode<T> node, T data) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return new AvlTreeNode<>(data);
        int cmp = node.val.compareTo(data);
        if (cmp > 0) {
            node.left = insert(node.left, data);
        } else if (cmp < 0) {
            node.right = insert(node.right, data);
        } else {
            throw new RuntimeException("duplicate!");
        }

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
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

    private AvlTreeNode<T> mostLeftChild(AvlTreeNode<T> node) {
        AvlTreeNode<T> current = node;
        /* loop down to find the leftmost leaf */
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
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
