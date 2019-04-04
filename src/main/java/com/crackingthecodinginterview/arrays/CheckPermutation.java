package com.crackingthecodinginterview.arrays;

import java.util.Arrays;

public class CheckPermutation {

	//to solve without sorting, we can count the chars in string
	public boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		char[] str1Chars = str1.toCharArray();
		Arrays.sort(str1Chars);
		
		char[] str2Chars = str2.toCharArray();
		Arrays.sort(str2Chars);
		
		for (int i = 0; i < str1Chars.length; i++) {
			if(str1Chars != str2Chars) return false;
		}
		
		return true;
	}
}
