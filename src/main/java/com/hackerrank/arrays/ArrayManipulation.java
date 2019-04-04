package com.hackerrank.arrays;

public class ArrayManipulation {
	public long arrayManipulation(int n, int[][] queries) {
		if(n == 0 || queries == null) return 0;
		long max = 0;
		long arr[] = new long[n+1];
		
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				arr[j] += queries[i][2];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
    }
}
