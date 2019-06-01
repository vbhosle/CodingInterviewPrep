package com.interviewbit;

import java.util.Arrays;
import java.util.List;

public class MatrixSearch {
	public int searchMatrix(List<List<Integer>> a, int b) {
		if (a == null || a.isEmpty())
			return 0;
		int rowIndex = rowBinarySearch(a, b);
		if (rowIndex == -1)
			return 0;
		return Arrays.binarySearch(a.get(rowIndex).toArray(new Integer[0]), b) >= 0 ? 1 : 0;
	}

	public int rowBinarySearch(List<List<Integer>> a, int b) {
		final int columns = a.get(0).size() - 1;
		int start = 0;
		int end = a.size() - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (b >= a.get(mid).get(0) && b <= a.get(mid).get(columns)) {
				return mid;
			}

			if (b > a.get(mid).get(columns)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}
}
