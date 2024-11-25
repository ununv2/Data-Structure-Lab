import java.util.ArrayList;
import java.util.function.BiFunction;

public class ExamSorter {
	ArrayList<Long>[] buckets;
	
	public ExamSorter() {
		buckets = (ArrayList<Long>[]) new ArrayList[30];
		for (int i = 0; i < 30; i++) {
			buckets[i] = new ArrayList<Long>();
		}
	}
	
	// TODO: Implement this method
	public void insert(long[] data) {
		for (int i = 0; i < data.length; i++) {
			int bucketNumber = (int) (data[i] / 100000) % 100;
			buckets[bucketNumber].add(data[i]);
		}
	}
	
	// TODO: Implement this method
	public void sort(int bucketNumber) {
		// Selection sort
		int maxindex;
		for (int unsorted = buckets[bucketNumber].size(); unsorted > 1; unsorted--) {
			maxindex = 0;
			for (int index = 1; index < unsorted; index++) {
				if (buckets[bucketNumber].get(maxindex) < buckets[bucketNumber].get(index))
					maxindex = index;
			}
			if (buckets[bucketNumber].get(maxindex) != buckets[bucketNumber].get(unsorted - 1))
				swap(buckets[bucketNumber], maxindex, unsorted - 1);
		}
	}
	
	private static void swap(ArrayList<Long> a, int pos1, int pos2) {
		long temp = a.get(pos1);
		a.set(pos1, a.get(pos2));
		a.set(pos2, temp);
	}
	
	// TODO: Implement this method
	public long[] collect() {
		int totalSize = 0;
		for (int i = 0; i < 30; i++) {
			totalSize += buckets[i].size();
		}
		
		long[] result = new long[totalSize];
		int currentIndex = 0;
		for (int b = 0; b < 30; b++) {
			for (int i = 0; i < buckets[b].size(); i++) {
				result[currentIndex] = buckets[b].get(i);
				currentIndex++;
			}
		}
		
		return result;
	}
	
	// TODO: Implement this method
	public long[] perform(long[] data) {
		insert(data);
		for (int i = 0; i < 30; i++) {
			sort(i);
		}
		return collect();
	}
}
