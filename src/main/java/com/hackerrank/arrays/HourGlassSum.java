package com.hackerrank.arrays;

public class HourGlassSum {

	public int hourglassSum(int[][] arr) {
		int maxSum = Integer.MIN_VALUE;
		int offset = 3;
		int sum;
		
		for (int i = 0; i <= arr.length-offset; i++) {
			for(int j = 0; j <= arr.length-offset; j++) {
				sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
				sum += arr[i+1][j+1];
				sum += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
				if(sum>maxSum) maxSum = sum;
			}
		}
		return maxSum;
	}
}
