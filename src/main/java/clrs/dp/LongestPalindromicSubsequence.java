package clrs.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

	public static int lpsLengthBruteForce(String input) {
		return lpsLengthBruteForce(input, 0, input.length() - 1);
	}

	private static int lpsLengthBruteForce(String input, int left, int right) {
		if(left == right)
			return 1;
		
		if(left > right) 
			return 0;
		
		if(input.charAt(left) == input.charAt(right))
			return 2 + lpsLengthBruteForce(input, left + 1, right - 1);
		
		return Math.max(lpsLengthBruteForce(input, left, right - 1), lpsLengthBruteForce(input, left+1, right));
	}
	
	public static int lpsLengthMemoized(String input) {
		int[][] dp = new int[input.length()][input.length()];
		
		for(int[] dpRow: dp)
			Arrays.fill(dpRow, -1);
		return lpsLengthMemoized(input, 0, input.length() - 1, dp);
	}

	private static int lpsLengthMemoized(String input, int left, int right, int[][] dp) {
		if(left == right)
			return 1;
		
		if(left > right) 
			return 0;
		
		if(dp[left][right] != -1)
			return dp[left][right];
		
		if(input.charAt(left) == input.charAt(right))
			dp[left][right] = 2 + lpsLengthMemoized(input, left + 1, right - 1, dp);
		
		else 
			dp[left][right] = Math.max(lpsLengthMemoized(input, left, right - 1, dp), lpsLengthMemoized(input, left+1, right, dp));
        
		return dp[left][right];
	}
	
	//TODO
	public String lpsUsingLcs(String input) {
		return null;
	}
}
