package com.crackingthecodinginterview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1.1
// Assumes single word no spaces included
public class UniqueCharacters {
	
	// If character set is limited to a-z, we can return false if string length is greater that 26
	public boolean hasUniqueCharacters(String str) {
		if(str == null || str.length() == 0) throw new IllegalArgumentException();
		
		str = str.toLowerCase();
		Set<Character> seen = new HashSet<>();
		
		char currentChar;
		for (int i = 0; i < str.length(); i++) {
			currentChar = str.charAt(i);
			if(!seen.add(currentChar)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean hasUniqueCharactersAtoZ(String str) {
		if(str == null || str.length() == 0) throw new IllegalArgumentException();
		if(str.length() > 26) return false;
		
		char[] chars = str.toLowerCase().toCharArray();
		int checker = 0;
		int position;
		for (int i = 0; i < chars.length; i++) {
			position = chars[i] - 'a';
			
			if((checker & (1<<position)) > 1) return false;
			checker |= 1<<position;
		}
		
		return true;
	}
	
	public boolean hasUniqueCharactersWithoutAdditionalDataStructure(String str) {
		if(str == null || str.length() == 0) throw new IllegalArgumentException();
		
		char[] chars = str.toLowerCase().toCharArray();
		Arrays.sort(chars);
		
		char prev = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if(chars[i] == prev) {
				return false;
			}
			
			prev = chars[i];
		}
		
		return true;
	}
	
}
