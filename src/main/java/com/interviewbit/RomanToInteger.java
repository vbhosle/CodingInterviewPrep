package com.interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanToInteger {

	public static void main(String args[]) {
		System.out.println(new RomanToInteger().toInt("MMCDLXXV"));
	}
	final static Map<Character, Integer> romanValue = new HashMap<>();

	static {
		romanValue.put('I', 1);
		romanValue.put('V', 5);
		romanValue.put('X', 10);
		romanValue.put('L', 50);
		romanValue.put('C', 100);
		romanValue.put('D', 500);
		romanValue.put('M', 1000);
	}

	public int toInt(final String roman) {
		int result = 0;
		if (roman == null || roman.isEmpty())
			return 0;

		int current;

		for (int i = 0; i < (roman.length() - 1); i++) {
			current = romanValue.get(roman.charAt(i));

			// if next number is large, current number has to be subtracted
			if (romanValue.get(roman.charAt(i + 1)) > current) {
				current = -current;
			}

			result += current;
		}

		// add last value
		return result + romanValue.get(roman.charAt(roman.length() - 1));
	}

	public int toIntWithStream(final String roman) {
		if (roman == null || roman.isEmpty())
			return 0;

		final List<Integer> values = roman.chars()
										  .boxed().map(c -> romanValue.get((char) (int) c))
										  .collect(Collectors.toList());
		return values.get(values.size() - 1)
				+ IntStream.rangeClosed(0, roman.length() - 1)
					       .filter(i -> (i + 1) < roman.length())
					       .map(i -> values.get(i) * (values.get(i) < values.get(i + 1) ? -1 : 1))
					       .sum();
	}
}
