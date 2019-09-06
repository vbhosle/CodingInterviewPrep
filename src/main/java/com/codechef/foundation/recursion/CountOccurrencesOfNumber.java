package com.codechef.foundation.recursion;

public class CountOccurrencesOfNumber {

	public static void main(String[] args) {
		int[] arr = {20, 10 ,20, 10, 30, 10};
		System.out.println("Occurrence of 10: " + countOccurrencesLinear(arr, arr.length, 10));
		System.out.println("Occurrence of 20: " + countOccurrencesLinear(arr, arr.length, 20));
		System.out.println("Occurrence of 30: " + countOccurrencesLinear(arr, arr.length, 30));
		
		System.out.println("Occurrence of 10: " + countOccurrencesTree(arr, arr.length, 10));
		System.out.println("Occurrence of 20: " + countOccurrencesTree(arr, arr.length, 20));
		System.out.println("Occurrence of 30: " + countOccurrencesTree(arr, arr.length, 30));
	}

	public static int countOccurrencesLinear(int[] numbers, int size, int searchNumber) {
		if (numbers == null || size == 0) {
			return 0;
		}
		if (size == 1) {
			if(numbers[0] == searchNumber) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if(numbers[size - 1] == searchNumber) {
			return 1 + countOccurrencesLinear(numbers, size - 1 , searchNumber);
		}
		else {
			return countOccurrencesLinear(numbers, size - 1, searchNumber);
		}
	}
	
	public static int countOccurrencesTree(int[] numbers, int size, int searchNumber) {
		return countOccurrencesTreeHelper(numbers, 0, size - 1, searchNumber);
	}
	
	public static int countOccurrencesTreeHelper(int[] numbers, int low, int high, int searchNumber) {
		if(low > high) {
			return 0;
		}
		
		if(low == high) {
			if(numbers[low] == searchNumber) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int mid = (low + high) / 2;
		return countOccurrencesTreeHelper(numbers, low, mid, searchNumber)
				+ countOccurrencesTreeHelper(numbers, mid + 1, high, searchNumber);
	}
}
