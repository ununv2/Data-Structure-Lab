
public class TernaryHeap extends Heap{
	int[] mData;
	int size = 0;

	public TernaryHeap() {
		final int DEFAULT_CAPACITY = 31;
		mData = new int[DEFAULT_CAPACITY];
	} // default constructor

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int element) {
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();
		
	}

	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 3;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}

	public int top() throws Exception {
		if (size == 0)
			throw new Exception("Empty");
		return mData[0];
	}

	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Priority queue empty.");
		int minElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return minElem;
	}

	protected void percolateDown(int start) {
		int parent = start;
        int temp;

        while (true) {
            int child1 = 3 * parent + 1;
            int child2 = 3 * parent + 2;
            int child3 = 3 * parent + 3;

            int minChild = parent;

            if (child1 < size && mData[child1] < mData[minChild]) minChild = child1;
            if (child2 < size && mData[child2] < mData[minChild]) minChild = child2;
            if (child3 < size && mData[child3] < mData[minChild]) minChild = child3;

            
            if (minChild == parent) break;

            temp = mData[parent];
            mData[parent] = mData[minChild];
            mData[minChild] = temp;

            parent = minChild;
        }
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
