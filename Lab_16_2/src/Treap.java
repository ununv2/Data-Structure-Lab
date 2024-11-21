public class Treap {
    TreapNode root;
    int size;

    // Constructor with no parameters
    public Treap() {
        root = null;
        size = 0;
    }

    // Insert method for inserting bstValue and heapValue
    public TreapNode insert(int v, int h) {
        // First, check if the (v, h) pair already exists.
        TreapNode foundNode = find(v, root);
        if (foundNode != null) {
            return null; // Node already exists
        }

        // Insert the node as if in a BST.
        TreapNode newNode = new TreapNode(v, h);
        root = bstInsert(root, newNode);
        size++;

        // Rotate the node up the tree to maintain heap properties.
        root = rotateUp(root, newNode);
        return newNode;
    }

    // Helper method to perform BST insertion
    private TreapNode bstInsert(TreapNode current, TreapNode nodeToInsert) {
        if (current == null) {
            return nodeToInsert;
        }
        if (nodeToInsert.bstValue < current.bstValue) {
            current.left = bstInsert(current.left, nodeToInsert);
            current.left.parent = current;
        } else {
            current.right = bstInsert(current.right, nodeToInsert);
            current.right.parent = current;
        }
        return current;
    }

    // Helper method to rotate the node up to maintain heap properties
    private TreapNode rotateUp(TreapNode current, TreapNode nodeToRotate) {
        while (nodeToRotate.parent != null && nodeToRotate.heapValue < nodeToRotate.parent.heapValue) {
            TreapNode parent = nodeToRotate.parent;
            if (parent.left == nodeToRotate) {
                current = rotateRight(parent);
            } else {
                current = rotateLeft(parent);
            }
        }
        return current;
    }

    // Rotate right around the given node
    private TreapNode rotateRight(TreapNode node) {
        TreapNode newRoot = node.left;
        node.left = newRoot.right;
        if (newRoot.right != null) {
            newRoot.right.parent = node;
        }
        newRoot.right = node;
        newRoot.parent = node.parent;
        if (node.parent == null) {
            root = newRoot;
        } else if (node.parent.left == node) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }
        node.parent = newRoot;
        return newRoot;
    }

    // Rotate left around the given node
    private TreapNode rotateLeft(TreapNode node) {
        TreapNode newRoot = node.right;
        node.right = newRoot.left;
        if (newRoot.left != null) {
            newRoot.left.parent = node;
        }
        newRoot.left = node;
        newRoot.parent = node.parent;
        if (node.parent == null) {
            root = newRoot;
        } else if (node.parent.left == node) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }
        node.parent = newRoot;
        return newRoot;
    }

    // Helper method to find a node with the given bstValue
    private TreapNode find(int v, TreapNode current) {
        if (current == null) {
            return null;
        }
        if (v == current.bstValue) {
            return current;
        } else if (v < current.bstValue) {
            return find(v, current.left);
        } else {
            return find(v, current.right);
        }
    }
}
