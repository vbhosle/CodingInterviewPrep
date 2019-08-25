package com.hackerrank.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MissingNumbers {

	int[] missingNumbers(int[] arr, int[] brr) {
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < brr.length; i++) {
			count.merge(brr[i], 1, (old, neww) -> old + neww);
		}

		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			c = count.get(arr[i]);
			if (c == 1)
				count.remove(arr[i]);
			else
				count.put(arr[i], c - 1);
		}

		int result[] = new int[count.size()];
		Set<Integer> missing = count.keySet();
		Iterator<Integer> itr = missing.iterator();
		for (int i = 0; i < result.length; i++) {
			result[i] = itr.next();
		}

		Arrays.sort(result);
		return result;
	}
}
