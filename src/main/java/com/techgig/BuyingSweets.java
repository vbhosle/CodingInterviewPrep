package com.techgig;

import java.io.IOException;
import java.util.stream.IntStream;

public class BuyingSweets {

	private final static int modVal = 1000000007;
	
	public long sumOfCostFormula(int[] sweets) {
		if (sweets == null || sweets.length == 0)
			return 0;
		long tempSum = 0;
		long sum = 0;

		for (int i = sweets.length - 1; i >= 0; i--) {
			tempSum = mod(tempSum + sweets[i]);
			sum = mod(sum + mod(mod((i + 1) * sweets[i]) * tempSum));
		}

		return sum;
	}
	
	private long mod(long n) {
//		return n>modVal?n % modVal:n;
		return n % modVal;
	}
	public int sumOfCostBruteForce(int[] sweets) {
		int windowSize = 1;
		int sum = 0;
		int tempSum = 0;
		while(windowSize <= sweets.length) {
			int  combos= sweets.length - (windowSize - 1);
			for(int i = 0; i<=combos;i++) {
				tempSum = 0;
				int last = sweets[i+windowSize-1];
				for(int j=i; j<i+windowSize; j++) {
					tempSum += sweets[j]*last;
				}
				sum += tempSum;
			}
			windowSize++;
		}
		return sum;
	}
	
	public int sumOfPossibleCosts(int[] sweets) {
		if(sweets == null || sweets.length == 0) return 0;
		int[] sum = new int[1];
		int result = 0;
		for (int i = sweets.length - 1; i >= 0; i--) {
			sumOfPossibleCosts(sweets, 0, i, sum);
			result += sum[0];
			sum[0] = 0;
		}

		return result;
	}

	private int sumOfPossibleCosts(int[] sweets, int first, int last, int[] sum) {
		int subSum = 0;
		if (first == last) {
			subSum = sweets[first] * sweets[last] % 1000000007;
			sum[0] = sum[0] + subSum;
			return subSum % 1000000007;
		}
		int tempSum = sumOfPossibleCosts(sweets, (first + 1), last, sum);
		subSum = (sweets[first] * sweets[last] % 1000000007 + tempSum) % 1000000007;
		sum[0] = sum[0] + subSum;
		return subSum % 1000000007;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		final int N = Integer.parseInt(reader.readLine());
//		int[] input = new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = Integer.parseInt(reader.readLine());
//		}
		
//		System.out.println(sumOfPossibleCosts(input));
//		BuyingSweets solver = new BuyingSweets();
//		int[] sweets = new int[] { 1, 2, 3 };
//		System.out.println(solver.sumOfPossibleCosts(sweets));
//		sweets = new int[] {5,9};
//		System.out.println(solver.sumOfPossibleCosts(sweets));
//		System.out.println(solver.sumOfPossibleCosts(null));
//		System.out.println(solver.sumOfPossibleCosts(new int[0]));
		
//		int[] sweets = new int[] { 2 };
//		System.out.println(sumOfCostBruteForce(sweets));
//		int[] array = IntStream.generate(() -> 9).limit(1000).toArray();
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + ",");
//		}
		System.out.println(Integer.MAX_VALUE);
	}
}
