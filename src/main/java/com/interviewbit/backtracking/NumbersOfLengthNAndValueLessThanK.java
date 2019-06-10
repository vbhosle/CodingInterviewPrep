package com.interviewbit.backtracking;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {
	public int solve(ArrayList<Integer> digits, int length, int limit) {
		if(String.valueOf(limit).length() < length) return 0;
		int counter = 0;
		ArrayList<Integer> selectedDigits = new ArrayList<>();
		for (Integer digit : digits) {
			selectedDigits.add(digit);
			counter = helper(digits, length, limit, counter, selectedDigits);
			selectedDigits.remove(selectedDigits.size() - 1);
		}

		return counter;
	}

	public int helper(ArrayList<Integer> digits, int length, int limit, int counter,
			ArrayList<Integer> selectedDigits) {
		if (!isWithinLimit(selectedDigits, length, limit)) {
			//System.out.println("Limit crossed: " + selectedDigits);
			return counter;
		}
		if (selectedDigits.size() == length) {
			if (isWithinLimit(selectedDigits, length, limit)) {
				//System.out.println("Number found : " + selectedDigits);
				return counter + 1;
			} else
				return counter;
		}

		if(length > 1 && selectedDigits.get(0) == 0) {
			return counter;
		}
		
		for (Integer digit : digits) {
			selectedDigits.add(digit);
			counter = helper(digits, length, limit, counter, selectedDigits);
			selectedDigits.remove(selectedDigits.size() - 1);
		}

		return counter;
	}

	private boolean isWithinLimit(ArrayList<Integer> selectedDigits, int length, int limit) {
		int unitMultiplier = (int) Math.pow(10, length - 1);
		int sum = 0;
		for (Integer digit : selectedDigits) {
			sum += digit * unitMultiplier;
			unitMultiplier /= 10;
		}
		return sum < limit;
	}
	
	static class RunningSum{
		int[] unitValues;
		int index = -1;
		int sum = 0;
		int unitMultiplier;
		RunningSum(int length){
			unitValues = new int[length];
			unitMultiplier = (int) Math.pow(10, length-1);
		}
		
		void add(int n) {
			unitMultiplier /= 10;
			unitValues[++index] = n*unitMultiplier;
			sum+= unitValues[index];
		}
		
		void removeLast() {
			sum -= unitValues[index--];
			unitMultiplier *= 10; 
		}
	}

}