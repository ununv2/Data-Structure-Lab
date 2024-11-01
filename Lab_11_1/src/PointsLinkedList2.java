
public class PointsLinkedList2 extends PointsLinkedList{
	// Write this method
		// Find if there is a point in a linked list with the same value as p,
		// but with different nextValue or different preValue

		public boolean pointValueExist(Point p) throws Exception {
			PointListIterator itr = new PointListIterator(this.header);
			while(itr.hasNext()) {
				itr.next();
				if(itr.currentNode == this.header || itr.currentNode == null) {
					return false;
				}
				if(itr.currentNode.data.value == p.value && (itr.currentNode.data.nextValue != p.nextValue || itr.currentNode.data.preValue != p.preValue)) {
					return true;
				}
				
			}return false;
			
		}
	
	
}
