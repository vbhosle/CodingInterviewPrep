package com.udemy.andrei.math;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an integer n, find a number consisting only of digits 0 and 1, which is divisible by n
 * Note: This problem doesn't require to find minimum number.
 */
public class PigeonholePrinciple {
	
	public static String findMultipleWithOnlyZeroAndOneDigits(int n) {
		StringBuilder sb = new StringBuilder();
		int currentRem = 0;
		Map<Integer, Integer> remainderToOneCountMap = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			currentRem = (currentRem*10 + 1) % n;
			
			if(currentRem == 0) {
				for(int j = 1; j <= i; j++) {
					sb.append("1");
				}
				
				return sb.toString();
			}
			
			if(remainderToOneCountMap.containsKey(currentRem)) {
				int totalOne =  i - remainderToOneCountMap.get(currentRem);
				for(int j = 1; j <= totalOne; j++ ) {
					sb.append("1");
				}
				
				for(int j = 1; j <= remainderToOneCountMap.get(currentRem); j++) {
					sb.append("0");
				}
				
				return sb.toString();
			}
			
			remainderToOneCountMap.put(currentRem, i);
		}
	
		return sb.toString();
	}
}
