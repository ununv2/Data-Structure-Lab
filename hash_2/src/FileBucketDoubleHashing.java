
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




		return 0;
	}
	
	// TODO: Implement this method
	public int hash2(int id) {





		return 0;
	}
	
	// TODO: Implement this method
	public void add(File file) throws Exception {






	}
	
	
	// TODO: Implement this method
	public void rehash() throws Exception {






	}
	
	// TODO: Implement this method
	public void remove(int id){






	}


}
