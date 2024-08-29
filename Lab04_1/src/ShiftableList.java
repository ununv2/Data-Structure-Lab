// DListNode firstNode lastNode newFirstNode newLastNode

public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	//change the nth data (counting from header) to be a new first 
	//data of the list 
	public void shift(int n) throws Exception {
		DListNode x = header;
		for(int i=0;i<n;i++) {
			x=x.nextNode;
		}
		shift(x);
		
	}

	// shift the list such that the data at position newStart becomes the first data
	// for list a,b,c,d,e,f
	// if newStart is pointing at c, 
	// the new list will be c,d,e,f,a,b
	public void shift(DListNode newStart) {

		DListNode firstNode = super.header.nextNode;
		DListNode lastNode = super.header.previousNode;
		DListNode newLast = newStart.previousNode;
		lastNode.nextNode = firstNode;
		firstNode.previousNode = lastNode;
		super.header.nextNode = newStart;
		super.header.previousNode = newLast;
		newLast.nextNode = super.header;
		newStart.previousNode = super.header;
		
	}

}
