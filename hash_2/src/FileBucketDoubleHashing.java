
public class FileBucketDoubleHashing extends FileBucketOpenAddressing {

	static double MAXFACTOR = 0.75;
	int occupiedSlots = 0;

	public FileBucketDoubleHashing() {
		this(DEFAULT_SIZE);
	}

	public FileBucketDoubleHashing(int size) {
		super(size);
	}
	
	// TODO: Implement this method
	public int hash(int id) {
		return id % array.length;
	}
	
	// TODO: Implement this method
	public int hash2(int id) {
		if (id % 2 == 0) {
			return id % 5;
		} else {
			return id % 4;
		}
	}
	
	// TODO: Implement this method
	public void add(File file) throws Exception {
		int h = hash(file.getId());
		int hash2Result = hash2(file.getId());
		int emptySlotPosition = -1;
		int i;
		final int smallNum = 5; // a small threshold
		for (i = 0; i < currentSize + smallNum; i++) {
			if (array[h] == null || array[h].getId() == file.getId())
				break;
			if (array[h] == DELETED && emptySlotPosition == -1) {
				emptySlotPosition = h;
			}
			h = (h + hash2Result) % array.length;
		}
		if (i >= currentSize + smallNum) {
			rehash();
			add(file);
		} else {
			if (array[h] == null) {
				if (emptySlotPosition != -1) {
					array[emptySlotPosition] = file;
				} else {
					array[h] = file;
					occupiedSlots++;
				}
				currentSize++;
				double currentLoadFactor = (double) (occupiedSlots / array.length);
				if (currentLoadFactor > MAXFACTOR)
					rehash();
			}
		}
	}
	
	
	// TODO: Implement this method
	public void rehash() throws Exception {
		File[] oldArray = array;
		array = new File[nextPrime(array.length * 2)];
		currentSize = 0;
		occupiedSlots = 0;
		for (int i = 0; i < oldArray.length; i++) {
			if (oldArray[i] != null && oldArray[i] != DELETED)
				add(oldArray[i]);
		}
	}
	
	// TODO: Implement this method
	public void remove(int id){
	    int index = find(id);
	    if(index != -1 && array[index] != null){
	       array[index] = DELETED; 
	       currentSize--; 
	    }
	}
	
	// Additional method
	public int find(int id) {
		final int smallNum = 5;
		int h = hash(id);
		int hash2Result = hash2(id);
		for (int i = 0; i < currentSize + smallNum; i++) {
			if (array[h] == null || array[h].getId() == id)
				return h;
			h = (h + hash2Result) % array.length;
		}
		return -1;
	}


}
