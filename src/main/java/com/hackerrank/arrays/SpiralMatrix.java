package com.hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> traverseSpiral(int[][] data) {
		List<Integer> result = new ArrayList<>(data.length * data[0].length);
		int top = 0;
		int right = data[0].length - 1;
		int bottom = data.length - 1;
		int left = 0;

		while (true) {
			if (left > right)
				break;
			for (int i = left; i <= right; i++) {
				result.add(data[top][i]);
			}
			top++;

			if (top > bottom)
				break;
			for (int i = top; i <= bottom; i++) {
				result.add(data[i][right]);
			}

			right--;

			if (left > right)
				break;
			
			for(int i = right; i >= left; i--) {
				result.add(data[bottom][i]);
			}
			
			bottom--;
			
			if(top > bottom) break;
			for(int i = bottom; i >= top; i--) {
				result.add(data[i][left]);
			}
			
			left++;
		}
		return result;
	}
}
