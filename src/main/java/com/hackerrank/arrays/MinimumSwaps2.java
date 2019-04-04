package com.hackerrank.arrays;

public class MinimumSwaps2 {

	public int minimumSwaps(int[] arr) {
		if(arr == null || arr.length < 1) return 0;
		int swaps = 0;
		int idx;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != (i+1)) {
				idx = indexOf(arr, i+1);
				swap(arr, i, idx);
				swaps++;
			}
			
		}

		return swaps;
    }
	
	public void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
		public int indexOf(int[]q, int n) {
			if(q == null || q.length == 0) return -1;
			for (int i = 0; i < q.length; i++) {
				if(q[i] == n) return i;
			}
			
			return -1;
		}
}
