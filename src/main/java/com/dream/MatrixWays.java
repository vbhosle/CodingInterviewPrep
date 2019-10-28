package com.dream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixWays {

	public static void main(String[] args) {
		System.out.println(numberOfPaths(
				Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1))));
	}


	private static final int MOD = 1000_000_007;

	public static int numberOfPaths(List<List<Integer>> a) {
		if (a == null || a.isEmpty())
			return 0;
		int rows = a.size();
		int columns = a.get(0).size();
		int[][] ways = new int[rows][columns];

		// initialize first row
		for (int col = 0; col < columns; col++) {
			if (isObstacle(a, 0, col))
				break;
			ways[0][col] = 1;
		}

		// initialize first column
		for (int row = 0; row < rows; row++) {
			if (isObstacle(a, row, 0))
				break;
			ways[row][0] = 1;
		}

		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < columns; col++) {
				if (!isObstacle(a, row, col)) {
					ways[row][col] = (ways[row][col - 1] % MOD + ways[row - 1][col] % MOD) % MOD;
				}
			}
		}

		return ways[rows - 1][columns - 1] % MOD;
	}

	public static boolean isObstacle(List<List<Integer>> a, int row, int col) {
		return a.get(row).get(col) == 0;
	}

}
