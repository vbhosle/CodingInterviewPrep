package com.codechef.foundation.dynamic;

public class Delish {

	//https://www.codechef.com/problems/DELISH
	public static void main(String[] args) {
//		System.out.println(Math.log10(Integer.MAX_VALUE));
//		int[] x = {2, -1, 4, 1, 6, -10, 10, 6, -2};
//		int[] x = {5 ,4 ,3 ,2, 1};
		int[] x = {1 ,1 ,-1,-1};
		System.out.println(maxDelishValue(x));
	}
	
	public static long maxDelishValue(int[] delishValues) {
		int len = delishValues.length;
		long[] highestAtj = new long[len];
		long[] lowestAtj = new long[len];
		long[] highestFromk = new long[len];
		long[] lowestFromk = new long[len];
		
		//dynamic programming used to find maximum sum of the continuous subsequence
		//for each new item, decide if to add to previous sum or start a new sum equal to current item
		highestAtj[0] = delishValues[0];
		lowestAtj[0] = delishValues[0];
		for(int i = 1; i < len; i++) {
			highestAtj[i] = Math.max(delishValues[i], delishValues[i] + highestAtj[i-1]);
			lowestAtj[i] = Math.min(delishValues[i], delishValues[i] + lowestAtj[i-1]);
		}
		
		highestFromk[len - 1] = delishValues[len - 1];
		lowestFromk[len - 1] = delishValues[len - 1];
		for(int i = len - 1 - 1 ; i >= 0; i--) {
			highestFromk[i] = Math.max(delishValues[i], delishValues[i] + highestFromk[i+1]);
			lowestFromk[i] = Math.min(delishValues[i], delishValues[i] + lowestFromk[i+1]);
		}
		
		long max = Long.MIN_VALUE;
		for(int j = 0; j < len - 1; j++) {
			max = Math.max(max, Math.abs(highestAtj[j] - lowestFromk[j+1]));
			max = Math.max(max, Math.abs(lowestAtj[j] - highestFromk[j+1]));
		}
		
		return max;
	}

}
