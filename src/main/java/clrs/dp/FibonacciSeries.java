package clrs.dp;

import java.util.Arrays;

public class FibonacciSeries {

	public static long fibonacciBruteForce(int n) {
		if(n == 0 || n == 1)
			return 1L*n;
		
		return fibonacciBruteForce(n-1) + fibonacciBruteForce(n - 2);
	}
	
	public static long fibonacciRecursive(int n) {
		long[] memo = new long[n+1];
		Arrays.fill(memo, Long.MIN_VALUE);
		return fibonacciRecursive(n, memo);
	}

	private static long fibonacciRecursive(int n, long[] memo) {
		if(memo[n] >= 0)
			return memo[n];
		
		if(n == 0 || n == 1) {
			memo[n] = n;
		}
		else {
			long result = fibonacciRecursive(n - 1, memo) + fibonacciRecursive(n - 2, memo);
			memo[n] = result;
		}
		
		return memo[n];
	}
	
	public static long fibonacciIterativeV1(int n) {
		if(n == 0 || n == 1) return n;
		
		long[] memo = new long[n+1];
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		
		return memo[n];
	}
	
	public static long fibonacciIterativeV2(int n) {
		if(n == 0 || n == 1) return n;
		
		long prevPrev = 0L;
		long prev = 1L;
		long current = 0L;
		for(int i = 2; i <= n; i++) {
			current = prevPrev + prev;
			prevPrev = prev;
			prev = current;
		}
		
		return current;
	}
}
