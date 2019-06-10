package com.interviewbit.backtracking;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {
	public int solve(ArrayList<Integer> digits, int length, int limit) {
		if(String.valueOf(limit).length() < length) return 0;
		int counter = 0;
		RunningSum runningSum = new RunningSum(length);
		for (Integer digit : digits) {
			runningSum.add(digit);
			counter = helper(digits, length, limit, counter, runningSum);
			runningSum.removeLast();
		}

		return counter;
	}

	public int helper(ArrayList<Integer> digits, int length, int limit, int counter,
			RunningSum runningSum) {
		if (!(runningSum.sum < limit)) {
			//System.out.println("Limit crossed: " + runningSum.sum);
			return counter;
		}
		if (runningSum.index == (length - 1)) {
			if (runningSum.sum < limit) {
				//System.out.println("Number found : " + runningSum.sum);
				return counter + 1;
			} else
				return counter;
		}

		if(length > 1 && runningSum.unitValues[0] == 0) {
			return counter;
		}
		
		for (Integer digit : digits) {
			runningSum.add(digit);
			counter = helper(digits, length, limit, counter, runningSum);
			runningSum.removeLast();
		}

		return counter;
	}

//	private boolean isWithinLimit(ArrayList<Integer> selectedDigits, int length, int limit) {
//		int unitMultiplier = (int) Math.pow(10, length - 1);
//		int sum = 0;
//		for (Integer digit : selectedDigits) {
//			sum += digit * unitMultiplier;
//			unitMultiplier /= 10;
//		}
//		return sum < limit;
//	}
	
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
			unitValues[++index] = n*unitMultiplier;
			sum+= unitValues[index];
			unitMultiplier /= 10;
		}
		
		void removeLast() {
			sum -= unitValues[index--];
			unitMultiplier = unitMultiplier == 0? 1:  (unitMultiplier* 10); 
		}
	}
	
	public static void main(String[] args) {
		RunningSum runningSum = new RunningSum(3);
		runningSum.add(2);
		runningSum.add(3);
		runningSum.add(4);
		runningSum.removeLast();
		runningSum.removeLast();
		runningSum.removeLast();
		runningSum.add(3);
	}

}