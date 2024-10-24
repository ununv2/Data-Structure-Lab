
public class Sort {
	//Hint: You can create other methods and then use sortFrequency to call them.

	public static int[] sortFrequency(int[] x) {
		int[] frequency = new int[11];
		for(int i : x) {
			frequency[i]++;
		}
		Pair[] p = new Pair[10];
		for(int i=1; i<=10; i++) {
			p[i-1] = new Pair(i,frequency[i]);
		}
		bubbleSort(p);
		int count = 0;
		for (Pair pair : p) {
            if (pair.freq > 0) {
                count++;
            }
        }
		int[] ans = new int[count];
		int index = 0;
		for(Pair pair: p) {
			if(pair.freq > 0) {
				ans[index++] = pair.value;
			}
		}
		return ans;
	}

	public static void bubbleSort(Pair[] p) {
		for(int pass=1; pass<=p.length-1; pass++) {
			for(int element=0; element<=p.length-2; element++) {
				if(p[element].freq < p[element+1].freq) {
					swap(p, element, element+1);
				}
				else if (p[element].freq == p[element + 1].freq && p[element].value > p[element + 1].value) {
                    swap(p, element, element + 1);
					
				}
			}
		}
	}
	public static void swap(Pair[] array, int a, int b) {
		Pair temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		
	}

}
