package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainbowA {

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int testCases = reader.nextInt();
		int[] arr;
		int n;
		while(testCases > 0) {
			n = reader.nextInt();
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = reader.nextInt();
			}
			System.out.println(isRainbowArray(arr));
			
			testCases--;
		}
	}
	
	public static String isRainbowArray(int[] arr) {
		if(arr == null || arr.length == 0) return "no";
		
		int currentNumber = 1;
		int mid = arr.length/2;
		int left = 0;
		int right;
		
		while (left <= mid) {
			right = arr.length - 1 - left;
			if(arr[left] == currentNumber && arr[right] == currentNumber) {
				left++;
				continue;
			}
			
			currentNumber++;
			if(arr[left] != currentNumber || arr[right] != currentNumber) {
				return "no";
			}
		}
		
		return currentNumber == 7 ? "yes": "no";
	}
	
	private static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
