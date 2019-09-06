package com.codechef.foundation.recursion;

public class CountSevens {

	public static void main(String[] args) {
		int number = 3762797;
		String outputString = "Count of 7 in %d is %d";
		System.out.println(String.format(outputString, number, count7s(number)));
		number = 7007;
		System.out.println(String.format(outputString, number, count7s(number)));
		number = 7777;
		System.out.println(String.format(outputString, number, count7s(number)));
	}
	
	public static int count7s(int number) {
		if(number == 0) return 0;
		if(number%10 == 7) return 1 + count7s(number/10);
		else return count7s(number/10);
	}

}
