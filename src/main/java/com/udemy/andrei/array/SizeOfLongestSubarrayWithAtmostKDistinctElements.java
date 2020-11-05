package com.udemy.andrei.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SizeOfLongestSubarrayWithAtmostKDistinctElements {

	public static void main(String[] args) {
		long product = toDigits(4421).stream().mapToLong(i -> i).reduce(1L, (n1, n2) -> n1*n2);
		long sum = toDigits(4421).stream().mapToLong(i -> i).reduce(0L, (n1, n2) -> n1+n2);
		System.out.println(product);
		System.out.println(sum);
	}

	public static List<Integer> toDigits(int n){
        List<Integer> digits = new ArrayList<>();
        while(n != 0){
            digits.add(n%10);
            n /= 10;
        }
        
        return digits;
    }

	public static int sizeOfLongestSubArray(int[] arr, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		int count = 0;
		int right;
		int ans = 0;

		for (right = 0; right < arr.length; right++) {
			if (frequency.merge(arr[right], 1, (old, n) -> old + 1) == 1) {
				count++;
			}

			if (count > k)
				break;
		}

		if (count <= k)
			return arr.length;

		if (frequency.merge(arr[right--], 1, (old, n) -> --old == 0 ? null : old) == null) {
			count--;
		}

		ans = k;

		for (int left = 1; left < arr.length; left++) {
			if (frequency.merge(arr[left - 1], 1, (old, n) -> --old == 0 ? null : old) == null) {
				count--;
			}

			while (right < (arr.length - 1)) {
				if (frequency.merge(arr[++right], 1, (old, n) -> old + 1) == 1) {
					count++;
				}

				if (count > k)
					break;
			}

			if (count <= k)
				return Math.max(ans, arr.length - left + 1);

			if (frequency.merge(arr[right--], 1, (old, n) -> --old == 0 ? null : old) == null) {
				count--;
			}

			ans = Math.max(ans, right - left + 1);
		}

		return ans;
	}

}
