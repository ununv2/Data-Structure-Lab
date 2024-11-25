import java.util.function.BiFunction;

public class Sort {
	public static void sort(int[] data, BiFunction<Integer, Integer, Integer> comparator) {
		// This solution will use selection sort
		int maxindex;
		for (int unsorted = data.length; unsorted > 1; unsorted--) {
			maxindex = 0;
			for (int index = 1; index < unsorted; index++) {
				if (comparator.apply(data[maxindex], data[index]) == -1)
					maxindex = index;
			}
			if (comparator.apply(data[maxindex], data[unsorted - 1]) != 0)
				swap(data, maxindex, unsorted - 1);
		}
	}
	
	private static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
}
