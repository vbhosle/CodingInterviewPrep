package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Salary {

	public static void main(String[] args) {
		FastReader reader = new FastReader();
		int testCases = reader.nextInt();
		int n;
		int[] wages;
		
		while(testCases > 0) {
			n = reader.nextInt();
			wages = new int[n];
			for(int i = 0; i<n; i++) {
				wages[i] = reader.nextInt();
			}
			
			System.out.println(minMoves(wages));
			testCases--;
		}
	}

	private static int minMoves(int[] wages) {
		if(wages == null || wages.length == 1) return 0;
		Arrays.sort(wages);
		int moves = 0;
		int difference, wagesEqualizedSoFar;
		for(int i = wages.length - 1 ; i > 0; i--) {
			wagesEqualizedSoFar = wages.length - i;
			difference = wages[i] - wages[i-1];
			moves += difference * wagesEqualizedSoFar ; 
		}
		
		return moves;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
