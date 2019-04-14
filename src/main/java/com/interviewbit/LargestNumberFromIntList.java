package com.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFromIntList {
	
	public String largestNumber(final List<Integer> A) {
		if(A == null || A.isEmpty()) return "";
		if(A.stream().allMatch(i -> i == 0))
			return "0";
		int len = A.size();
		List<String> B = new ArrayList<>(len);
		for(int i = 0; i< len; i++) {
			B.add(""+A.get(i));
		}
		B.sort(new CustomStringComparator().reversed());
		return String.join("", B.toArray(new String[0]));
	}

	static class CustomStringComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			BigInteger int1 = new BigInteger(s1+s2);
			BigInteger int2 = new BigInteger(s2+s1);
			return int1.compareTo(int2);
		}
		
	}
}
