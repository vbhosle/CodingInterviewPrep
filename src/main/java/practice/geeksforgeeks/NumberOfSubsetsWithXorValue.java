package practice.geeksforgeeks;

public class NumberOfSubsetsWithXorValue {

	public static void main(String[] args) {
		long[] arr = {1, 2, 3, 4, 5};
		int k = 4;
		System.out.println(subsetXOR(arr, k));
	}

	public static long subsetXOR(long[] arr, int k) {
		int n = arr.length;

		// Find maximum element in arr[]
		long max_ele = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max_ele)
				max_ele = arr[i];

		// Maximum possible XOR value
		int m = (1 << (log2(max_ele) + 1)) - 1;

		// The value of dp[i][j] is the number of subsets having
		// XOR of their elements as j from the set arr[0...i-1]
		long[][] dp = new long[n + 1][m + 1];

		// Initializing all the values of dp[i][j] as 0
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = 0;

		// The xor of empty subset is 0
		dp[0][0] = 1;

		// Fill the dp table
		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = dp[i - 1][j] + dp[i - 1][(int) (j ^ arr[i - 1])];

		// The answer is the number of subset from set
		// arr[0..n-1] having XOR of elements as k
		return dp[n][k];
	}

	public static long log2(long x) {
		// https://www.techiedelight.com/calculate-log-base-2-in-java/
		return (long) (Math.log(x) / Math.log(2) + 1e-10);
	}

}
