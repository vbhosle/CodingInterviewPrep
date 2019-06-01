package com.interviewbit;

import java.util.List;

//Tushar roy: https://www.youtube.com/watch?v=LPFhl65R7ww
public class MedianOfArray {

	public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
		int lenA = A.size();
		int lenB = B.size();
		if (lenA > lenB) {
			return findMedianSortedArrays(B, A);
		}

		int low = 0;
		int high = lenA;

		while (low <= high) {
			int partitionA = (low + high) / 2;
			int partitionB = (lenA + lenB + 1) / 2 - partitionA;

			int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : A.get(partitionA - 1);
			int minRightA = partitionA == lenA ? Integer.MAX_VALUE : A.get(partitionA);

			int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : B.get(partitionB - 1);
			int minRightB = partitionB == lenB ? Integer.MIN_VALUE : B.get(partitionB);

			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				// found solution
				if ((lenA + lenB) % 2 == 0) {
					return (1.0 * Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					return Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) {
				// move left in X
				high = partitionA - 1;
			} else {
				// move right in X
				low = partitionA + 1;
			}
		}

		throw new IllegalArgumentException();
	}

}
