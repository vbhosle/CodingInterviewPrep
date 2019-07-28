package practice.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumIncreasingSubsequence {
	/*
	Input:
		2
		7
		1 101 2 3 100 4 5
		4
		10 5 4 3

		Output:
		106
		10
		*/
/*
	1
	21
	597 22 349 200 669 485 282 735 54 1000 419 939 901 789 128 468 729 894 649 484 808
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = null;
		for (int i = 1; i <= T; i++) {
			br.readLine();
			arr = getArray(br.readLine());
			System.out.println(maxSumIncreasingSubsequence(arr));
		}
	}

	public static int[] getArray(String str) {
		String[] strArr = str.split("\\s");
		int[] result = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}

		return result;
	}

	public static int maxSumIncreasingSubsequence(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int[] last = new int[arr.length];
		int[] sum = new int[arr.length];

		last[0] = 1;
		sum[0] = arr[0];
		int maxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && last[j] > last[i] && sum[j] > sum[i]) {
					last[i] = last[j];
					sum[i] = sum[j];
				}
			}
			last[i]++;
			sum[i] += arr[i];
			if (sum[i] > maxSum) {
				maxSum = sum[i];
			}
		}

		return maxSum;
	}

}
