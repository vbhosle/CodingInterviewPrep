package com.crackingthecodinginterview.stringmanipulation;

public class MakingAnagrams {

	public int makeAnagram(String a, String b) {
		int[] charCounts = new int[26];

		// count chars in a
		for (int i = 0; i < a.length(); i++) {
			charCounts[a.charAt(i) - 'a']++;
		}

		// reduce count for chars found in b
		for (int i = 0; i < b.length(); i++) {
			charCounts[b.charAt(i)-'a']--;
		}
		
		int  differences = 0;
		// sum the differences
		for (int i = 0; i < charCounts.length; i++) {
			differences += Math.abs(charCounts[i]);
		}
		return differences;
	}

}
