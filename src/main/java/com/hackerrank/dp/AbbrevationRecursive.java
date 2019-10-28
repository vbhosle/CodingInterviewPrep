package com.hackerrank.dp;

public class AbbrevationRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Complete the abbreviation function below.
	static String abbreviation(String a, String b) {
		return isAbbreviation(a, b) ? "YES" : "NO";
	}

	static boolean isAbbreviation(String a, String b) {
		if (a == null)
			a = "";
		if (b == null)
			b = "";
		if (a.length() == 0 && b.length() == 0)
			return true;
		if (b.length() == 0) {
			if (allCharsLowerCase(a))
				return true;
			else
				return false;
		}
		if (a.length() == 0)
			return false;

		int lenA = a.length();
		int lenB = b.length();
		char lastA = a.charAt(lenA - 1);
		char lastB = b.charAt(lenB - 1);
		char upperCharA;
		boolean isUpperCase = Character.isUpperCase(lastA);
		if (isUpperCase) {
			if (lastA != lastB) {
				return false;
			} else {
				return isAbbreviation(a.substring(0, lenA - 1), b.substring(0, lenB - 1));
			}
		} else {
			upperCharA = Character.toUpperCase(lastA);
			if (upperCharA != lastB) {
				// drop the char in A
				return isAbbreviation(a.substring(0, lenA - 1), b);
			} else {
				// uppercase the lower char and match or drop it
				return isAbbreviation(a.substring(0, lenA - 1), b.substring(0, lenB - 1))
						|| isAbbreviation(a.substring(0, lenA - 1), b);
			}
		}
	}

	private static boolean allCharsLowerCase(String a) {
		for(char c: a.toCharArray()) {
			if(Character.isUpperCase(c)) return false;
		}
		return true;
	}
}
