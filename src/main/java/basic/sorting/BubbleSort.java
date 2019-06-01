package basic.sorting;

//Best case: O(n)
//Worst case: O(n^2)
public class BubbleSort {

	public int[] sort(int[] arr) {
		if(arr == null || arr.length == 1) return arr;
		boolean swapped;
		for (int i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					swapped = true;
					swap(arr, j, j+1);
				}
			}
			
			if(!swapped) return arr;
		}
		
		return arr;
	}

	private void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
