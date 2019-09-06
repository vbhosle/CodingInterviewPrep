package com.codechef.foundation.recursion;

public class ReplaceChar {

	public static void main(String[] args) {
		String str = "sabados";
		System.out.println(str.replace('a', 'i').equals(replaceChar(str, 'a', 'i')));

		str = "liliput";
		System.out.println(str.replace('i', 'a').equals(replaceChar(str, 'i', 'a')));

		str = "zzz";
		System.out.println(str.replace('z', 'o').equals(replaceChar(str, 'z', 'o')));
	}

	public static String replaceChar(String str, char target, char replacement) {
		return replaceCharHelper(str, target, replacement, 0, str.length() - 1);
	}

	public static String replaceCharHelper(String str, char target, char replacement, int low, int high) {
		if (low > high)
			return "";
		if (low == high) {
			if (str.charAt(low) == target)
				return "" + replacement;
			else
				return str.substring(low, low + 1);
		}
		int mid = (low + high) / 2;
		return replaceCharHelper(str, target, replacement, low, mid)
				+ replaceCharHelper(str, target, replacement, mid + 1, high);
	}

}
