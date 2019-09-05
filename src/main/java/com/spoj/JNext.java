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
			System.out.println(solver.nextNumber(input));
		}
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
	
	public long nextNumber(int[] digits){
	    System.out.println(Arrays.toString(digits));
		if(digits == null || digits.length <= 1) return -1L;
		
       // find index where adjacent numbers are in ascending order
       int pivot = digits.length - 1;
       while(pivot > 0){
       	if(digits[pivot-1] < digits[pivot])
       		break;
       	pivot--;
       }
       
    	if(pivot == 0) return -1L;
        pivot--;
        
		// find smallest number greater than number at pivot
		int nextHigherDigitIndex = pivot + 1;
		for(int i = pivot + 1; i < digits.length; i++){
			if(digits[i] > digits[pivot] && digits[i] < digits[nextHigherDigitIndex]){
				nextHigherDigitIndex = i;
			}
		}
		
		//swap pivot with nextHigherDigitIndex
		int temp = digits[pivot];
		digits[pivot] = digits[nextHigherDigitIndex];
		digits[nextHigherDigitIndex] = temp;
		
		Arrays.sort(digits, pivot + 1, digits.length);
		return intArrayToNumber(digits);
	}
}
