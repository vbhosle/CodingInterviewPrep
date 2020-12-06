package clrs.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static long recursiveMatrixChain(int[] dimensions) {
		int n = dimensions.length - 1;
		return recursiveMatrixChain(dimensions, 1, n);
	}
	
	public static long recursiveMatrixChain(int[] dimensions, int i, int j) {
		if(i == j) return 0L;
		
		long min = Long.MAX_VALUE;
		for(int k = i; k < j; k++) {
			min = Math.min(min, recursiveMatrixChain(dimensions, i, k) 
								+ recursiveMatrixChain(dimensions, k+1, j) 
								+ 1L*dimensions[i-1]*dimensions[k]*dimensions[j]);	
		}
		
		return min;
	}
	
	public static long recursiveMatrixChainMemoized(int[] dimensions) {
		int n = dimensions.length - 1;
		long[][] memo = new long[n+1][n+1];
		for(long[] m: memo) {
			Arrays.fill(m, Long.MAX_VALUE);
		}
		
		return recursiveMatrixChainMemoized(dimensions, 1, n, memo);
	}
	
	public static long recursiveMatrixChainMemoized(int[] dimensions, int i, int j, long[][] memo) {
		if(memo[i][j] < Long.MAX_VALUE)
			return memo[i][j];
		
		if(i == j) {
			memo[i][j] = 0L;
		}
		else {
			for(int k = i; k < j; k++) {
				memo[i][j] = Math.min(memo[i][j], recursiveMatrixChain(dimensions, i, k) 
									+ recursiveMatrixChain(dimensions, k+1, j) 
									+ 1L*dimensions[i-1]*dimensions[k]*dimensions[j]);	
			}
		}
		
		return memo[i][j];
	}
	
	public static String matrixChainMemoized(int[] dimensions) {
		int n = dimensions.length - 1;
		long[][] memo = new long[n+1][n+1];
		int[][] choices = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(memo[i], Long.MAX_VALUE);
			memo[i][i] = 0L;
		}
		
		for(int chainLen = 2; chainLen <= n; chainLen++) {
			for(int i = 1; i <= (n - chainLen + 1); i++) {
				int j = i + chainLen - 1;
				long q = Long.MAX_VALUE;
				
				for(int k = i; k < j; k++) {
					q = memo[i][k] + memo[k+1][j] + dimensions[i-1]*dimensions[k]*dimensions[j];
					
					if(q < memo[i][j]) {
						memo[i][j] = q;
						choices[i][j] = k;
					}
				}
			}
		}
		
		return buildParantesizedSolution(choices, 1, n).toString();
	}

	private static StringBuilder buildParantesizedSolution(int[][] choices, int i, int j) {
		if(i == j)
			return new StringBuilder("A").append(i);
		else {
			return new StringBuilder().append("(")
					                  .append(buildParantesizedSolution(choices, i, choices[i][j]))
					                  .append(buildParantesizedSolution(choices, choices[i][j] + 1, j))
					                  .append(")");
					                  
		}
	}
	
}
