package practice.geeksforgeeks;

import java.util.Arrays;

public class CountIncreasingSubsequences {

	static int numOfIncSubseqOfSizeK01(int arr[], int n, int k) {
		if(k == 0) return 1;
		if(k == 1) return n;
		
		//ignore the first row dp[0]
		int[][] dp = new int[k+1][n];
		
		//number of subsequence of size 1 ending in i-th element 
		Arrays.fill(dp[1], 1);
		
		for(int subSequenceSize = 2; subSequenceSize <= k; subSequenceSize++) {
			// if subsequence size is 2, we need atleast two numbers. Thus start from subsequence size
			for(int col = subSequenceSize-1; col < n; col++) {
				
				for(int j = 0; j < col; j++) {
					if(arr[col] > arr[j]) {
						dp[subSequenceSize][col] += dp[subSequenceSize - 1][j];
					}
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += dp[k][i];
		}
		
		return sum;
	}
	
	
	static int numOfIncSubseqOfSizeK(int arr[], int n, int k) {
		int dp[][] = new int[k][n], sum = 0;

		// count of increasing subsequences of size 1
		// ending at each arr[i]
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		// building up the matrix dp[][]
		// Here 'l' signifies the size of
		// increasing subsequence of size (l+1).
		for (int l = 1; l < k; l++) {

			// for each increasing subsequence of size 'l'
			// ending with element arr[i]
			for (int i = l; i < n; i++) {

				// count of increasing subsequences of size 'l'
				// ending with element arr[i]
				dp[l][i] = 0;
				for (int j = l - 1; j < i; j++) {
					if (arr[j] < arr[i]) {
						dp[l][i] += dp[l - 1][j];
					}
				}
			}
		}

		// sum up the count of increasing subsequences of
		// size 'k' ending at each element arr[i]
		for (int i = k - 1; i < n; i++) {
			sum += dp[k - 1][i];
		}

		// required number of increasing
		// subsequences of size k
		return sum;
	}
}
