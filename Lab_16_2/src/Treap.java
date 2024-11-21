public class Treap {
	TreapNode root;
	int size;
    public Treap() {
    	root = null;
    	size = 0;
    }
    public TreapNode insert(int v, int h) {
    	// if it exists, do nothing, return null ( find )
    	// else insert new node that contains these values ( insert )
    	// use heap value to rotate it up the tree [ small to large ] ( rotate AVL? )
    	// return node that we added
    	if(isExist(v,h)) {
    		return null;
    	}
    	TreapNode newNode = new TreapNode(v,h);
    	root = insertBST(root, newNode);
    	size++;
    	root = rebalance(newNode);
        return newNode;
 
    	
    }
    
    public TreapNode insertBST(TreapNode n, TreapNode toInsert) {
    	if(n == null) {
    		return toInsert;
    	}
    	if(toInsert.bstValue < n.bstValue) {
    		n.left = insertBST(n.left, toInsert);
    		n.left.parent = n;
    	}else {
    		n.right = insertBST(n.right, toInsert);
    		n.right.parent = n;
    	}
    	return n;
    }
    
    public boolean isExist(int v, int h) { 
		TreapNode temp = root;

		while (temp != null){
			if(temp.bstValue == v && temp.heapValue == h) {
				return true;
			}
			else if (v < temp.bstValue) {
					temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}
    private TreapNode rebalance(TreapNode nodeToRebalance) {
        while (nodeToRebalance.parent != null && nodeToRebalance.heapValue < nodeToRebalance.parent.heapValue) {
            TreapNode parent = nodeToRebalance.parent;
            if (parent.left == nodeToRebalance) {
                nodeToRebalance = rotateRight(parent);
            } else {
                nodeToRebalance = rotateLeft(parent);
            }
        }
        return root;
    }

    // Rotate right around the given node
    private TreapNode rotateRight(TreapNode node) {
        TreapNode newRoot = node.left;
        TreapNode lr = newRoot.right;
        node.left = lr;
        if (lr != null) {
            lr.parent = node;
        }
        newRoot.right = node;
        newRoot.parent = node.parent;
        node.parent = newRoot;
        if (newRoot.parent == null) {
            root = newRoot;
        } else if (newRoot.parent.left == node) {
            newRoot.parent.left = newRoot;
        } else {
            newRoot.parent.right = newRoot;
        }
        return newRoot;
    }

    // Rotate left around the given node
    private TreapNode rotateLeft(TreapNode node) {
        TreapNode newRoot = node.right;
        TreapNode rl = newRoot.left;
        node.right = rl;
        if (rl != null) {
            rl.parent = node;
        }
        newRoot.left = node;
        newRoot.parent = node.parent;
        node.parent = newRoot;
        if (newRoot.parent == null) {
            root = newRoot;
        } else if (newRoot.parent.left == node) {
            newRoot.parent.left = newRoot;
        } else {
            newRoot.parent.right = newRoot;
        }
        return newRoot;
    }
    



}

    
    