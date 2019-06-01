package basic.sorting;

// At every level there is O(n) work in total. There are log n levels. 
// therefore complexity is O(nlogn)
public class MergeSort {

	public int[] sort(int[] arr) {
		if (arr == null || arr.length == 1)
			return arr;
		mergeSort(arr, 0, arr.length-1);
		return arr;
	}

	private void mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return;
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, mid + 1, end);
	}

	private void merge(int[] arr, int start1, int end1, int start2, int end2) {
		int[] sortedArray = new int[end2 - start1 + 1];
		int offset = start1;
		int sortedArrayIndex = 0;
		while (start1 <= end1 && start2 <= end2) {
			if (arr[start1] < arr[start2]) {
				sortedArray[sortedArrayIndex++] = arr[start1++];
			} else {
				sortedArray[sortedArrayIndex++] = arr[start2++];
			}
		}
		
		while(start1 <= end1) {
			sortedArray[sortedArrayIndex++] = arr[start1++];
		}
		
		while(start2 <= end2) {
			sortedArray[sortedArrayIndex++] = arr[start2++];
		}
		
		for (int i = 0; i < sortedArray.length; i++) {
			arr[offset+i] = sortedArray[i];
		}
	}

}
