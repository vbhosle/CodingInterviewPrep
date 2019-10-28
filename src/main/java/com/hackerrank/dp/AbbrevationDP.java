package com.hackerrank.dp;

public class AbbrevationDP {

	// Complete the abbreviation function below.
	static String abbreviation(String a, String b) {
		int n = a.length();
		int m = b.length();
		boolean[][] dp = new boolean[n+1][n+1];
		dp[0][0] = true;
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (i < n && !Character.isUpperCase(a.charAt(i)))
					dp[i + 1][j] |= dp[i][j];
				if (i < n && j < m && equal(a.charAt(i), b.charAt(j)))
					dp[i + 1][j + 1] |= dp[i][j];
			}
		}
		
		return dp[n][m] ? "YES" : "NO";
	}

	public static boolean equal(char a, char b) {
		return Character.toUpperCase(a) == b;
	}

}
