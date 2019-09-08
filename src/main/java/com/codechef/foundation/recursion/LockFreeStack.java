package com.codechef.foundation.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LockFreeStack {

	public static void main(String[] args) {
		long m = 1000_000_000L;
		double result = m*(m+1)/2;
		System.out.println(result);
		System.out.println(m*(m+1)/2);
		FastReader reader = new FastReader();
		int testCases = reader.nextInt();
		int threadCount = 0;
		int[][] threadNumbers;
		int[] sequence;
		int numbersPerThread;
		int totalNumbers;

		while (testCases > 0) {
			totalNumbers = 0;
			threadCount = reader.nextInt();
			threadNumbers = new int[threadCount][];
			for (int i = 0; i < threadCount; i++) {
				numbersPerThread = reader.nextInt();
				threadNumbers[i] = new int[numbersPerThread];
				for (int j = 0; j < numbersPerThread; j++) {
					threadNumbers[i][j] = reader.nextInt();
					totalNumbers++;
				}
			}

			sequence = new int[totalNumbers];
			for (int i = 0; i < totalNumbers; i++) {
				sequence[i] = reader.nextInt();
			}

			System.out.println(validSequence(threadNumbers, sequence));
			testCases--;
		}
	}

	public static String validSequence(int[][] threadNumbers, int[] sequence) {
		Deque<Integer> currentStack = new LinkedList<>();
		boolean result = true;

		if (threadNumbers.length == 1) {
			for (int n : threadNumbers[0]) {
				currentStack.push(n);
			}

			int index = 0;
			while (!currentStack.isEmpty()) {
				if (currentStack.pop() != sequence[index++]) {
					result = false;
					break;
				}
			}
		} else {
			int[] threadTops = new int[threadNumbers.length];
			result = validSequence(threadNumbers, sequence, threadTops, currentStack);
		}
		return result ? "Yes" : "No";
	}

	public static boolean validSequence(int[][] threadNumbers, int[] sequence, int[] threadTops,
			Deque<Integer> currentStack) {
		if (currentStack.size() == sequence.length) {
			return true;
		}

		boolean result = false;
		int[] currentThread;

		int nextNumber;
		int threadTop;
		for (int threadIndex = 0; threadIndex < threadNumbers.length; threadIndex++) {
			currentThread = threadNumbers[threadIndex];
			threadTop = threadTops[threadIndex];
			if (threadTop < currentThread.length) {
				nextNumber = currentThread[threadTop];

				// optimization: early exit/break
				if (nextNumber != sequence[sequence.length - 1 -currentStack.size()])
					continue;

				threadTops[threadIndex]++;
				currentStack.push(nextNumber);

				result = validSequence(threadNumbers, sequence, threadTops, currentStack);

				currentStack.pop();
				threadTops[threadIndex]--;
				if (result)
					return true;
			}
		}

		return false;
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
