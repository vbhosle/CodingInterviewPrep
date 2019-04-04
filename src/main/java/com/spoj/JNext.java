package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// WRONG ANSWER!!
public class JNext {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		JNext solver = new JNext();
		int t = Integer.parseInt(reader.readLine());
		int[] input;
		for (int i = 1; i <= t; i++) {
			reader.readLine();
			input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			System.out.println(Arrays.toString(input));
			System.out.println(solver.nextHigherNumber(input));
		}
	}
	
	public long nextHigherNumber(int[] number) {
		if(number == null || number.length < 2) return -1;
		// starting from right, find the case where left number is less than right
		int i;
		for (i = number.length - 1; i > 0; i--) {
			if (number[i - 1] < number[i]) {
				break;
			}
		}

		if (i == 0)
			return -1;

		i--;
		// find the next higher number than number[i]
		int nextMaxIdx = 0;
		int leastDiff = 9-0;
		int currentDiff;
		for (int j = i + 1; j < number.length; j++) {
			currentDiff = (number[j] - number[i]);
			if (number[j] > number[i] && currentDiff<leastDiff) {
				leastDiff = currentDiff;
				nextMaxIdx = j;
			}
		}

		// swap
		int temp = number[i];
		number[i] = number[nextMaxIdx];
		number[nextMaxIdx] = temp;

		// sort the rest of array
		Arrays.sort(number, i + 1, number.length);

		return intArrayToNumber(number);
	}

	private long intArrayToNumber(int[] number) {
		long result = 0L;
		long placeMultiplier = 1L;
		for (int i = number.length - 1; i >= 0; i--) {
			result += number[i]*placeMultiplier;
			placeMultiplier*=10L;
		}

		return result;
	}
}
