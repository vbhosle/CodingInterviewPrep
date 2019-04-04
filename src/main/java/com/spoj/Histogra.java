package com.spoj;

import java.util.ArrayDeque;
import java.util.Deque;

public class Histogra {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}

	public long largestRectangleInHistogram(int[] histogram) {
		if (histogram == null || histogram.length == 0)
			return 0L;

		long max = 0;
		int poppedIdx = -1;
		int width;
		long tempArea = 0;
		Deque<Integer> indexStack = new ArrayDeque<>(histogram.length);
		int i;
		for (i = 0; i < histogram.length; i++) {

			if (indexStack.isEmpty() || histogram[indexStack.peek()] <= histogram[i]) {
				indexStack.push(i);
			} else {
				do {
					poppedIdx = indexStack.pop();
					width = indexStack.isEmpty() ? i : i - 1 - indexStack.peek();
					tempArea = histogram[poppedIdx] * (width);
					if (tempArea > max) {
						max = tempArea;
					}
				} while (!indexStack.isEmpty() && histogram[i] > histogram[indexStack.peek()]);
			}
		}

		while (!indexStack.isEmpty()) {
			poppedIdx = indexStack.pop();
			width = indexStack.isEmpty() ? i : i - 1 - indexStack.peek();
			tempArea = histogram[poppedIdx] * (width);
			if (tempArea > max) {
				max = tempArea;
			}
		}
		return max;
	}
}
