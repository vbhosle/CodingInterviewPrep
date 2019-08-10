package com.codechef.foundation.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LeCandy {

	public static void main(String[] args) throws java.lang.Exception {
		FastReader reader = new FastReader();

		int testCases = reader.nextInt();

		int candies;
		int n;
		int[] elephants;

		for (int i = 1; i <= testCases; i++) {
			n = reader.nextInt();
			candies = reader.nextInt();

			elephants = new int[n];
			for (int j = 0; j < n; j++) {
				elephants[j] = reader.nextInt();
			}

			System.out.println(makeAllHappy(candies, elephants));
		}
	}

	public static String makeAllHappy(int candies, int[] elephants) {
		if (elephants == null || elephants.length == 0)
			throw new IllegalArgumentException("Elephants can't be empty");
		int required = Arrays.stream(elephants).sum();
		return required <= candies ? "Yes" : "No";
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception ex) {
					ex.printStackTrace();
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
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return str;
		}
	}
}
