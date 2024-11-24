public class BSTNode {
	int data; // value stored in the node.
	BSTNode left; //pointer to lower left BSTNode.
	BSTNode right; //pointer to lower right BSTNode.
	BSTNode parent; //pointer to the BSTNode above.

	public BSTNode(int data){
		this(data,null,null,null);
	}
	
	public BSTNode(int data, BSTNode left, BSTNode right, BSTNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public static void main(String[] args) {
		BSTNode b = new BSTNode(9); 
	}
	
	// TODO: Implement this method
	public static BSTNode preorder2BST(int[] preorder) {
		
		return constructBST(preorder, 0, preorder.length-1,null);
	}
	public static BSTNode constructBST(int[] preorder, int start, int end, BSTNode parent) {
		if(start > end || start >= preorder.length || end >= preorder.length)
			return null;
		BSTNode n = new BSTNode(preorder[start], null, null, parent);
		//find right subtree
		int rightStart = start + 1;
		while(rightStart < preorder.length && preorder[rightStart] < preorder[start]){
			rightStart++;
		}
		n.left = constructBST(preorder, start+1, rightStart-1, n);
		n.right = constructBST(preorder, rightStart, end, n);

		return n;
	}
		
}