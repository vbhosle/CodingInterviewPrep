package basic.sorting;

public class InsertionSort{
	// Best case: O(n) There is only one comparision in while loop if array is already sorted. 
	// Worst case: O(n^2) If array is in reverse order, for each value of i, while loop compares i times; 1 + 2 + 3 + .. + n comparsions
	public int[] sort(int[] arr) {
		if (arr == null || arr.length < 2)
			return arr;

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

		return arr;
	}
}
