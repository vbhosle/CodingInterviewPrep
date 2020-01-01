package com.leetcode;

import java.math.BigInteger;

public class StringMatchStrstr {

	private static final BigInteger BASE = new BigInteger("256");
	private static final BigInteger MOD = new BigInteger("" + Integer.MAX_VALUE);

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(strStr(
				"mississippi",
				"issip"));
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - start));
	}

	public static int strStr(String haystack, String needle) {
		// base cases
		if (needle == null || needle.length() == 0)
			return 0;
		if (haystack == null || haystack.length() == 0)
			return -1;
		if (haystack.length() < needle.length())
			return -1;

		// calculate hash of needle of length n
		final BigInteger NEEDLE_HASH = getHash(needle, 0, needle.length() - 1);

		// calculate hash of n haystack characters
		BigInteger currentSubStrHash = getHash(haystack, 0, needle.length() - 1);

		final int MAX_POW = needle.length() - 1;
		final BigInteger MAX_MULTIPLIER = BASE.pow(MAX_POW).mod(MOD);

		// loop over haystack characters
		int i = 0;
		while ((haystack.length() - i) >= needle.length()) {
			// if hash match and individual char match return index
			if (currentSubStrHash.equals(NEEDLE_HASH) && needle.equals(haystack.subSequence(i, i + needle.length()))) {
				return i;
			}

			// else find next rolling hash
			if ((haystack.length() - i) > needle.length()) {
				currentSubStrHash = currentSubStrHash
						.subtract(MAX_MULTIPLIER.multiply(BigInteger.valueOf(haystack.charAt(i)).mod(MOD)).mod(MOD));
				currentSubStrHash = currentSubStrHash.multiply(BASE).mod(MOD)
						.add(BigInteger.valueOf(haystack.charAt(i + needle.length()))).mod(MOD);
			}
			i++;
		}

		return -1;
	}

	public static BigInteger getHash(String s, int start, int end) {
//		long startTime = System.currentTimeMillis();
		BigInteger hash = BigInteger.ZERO;
		int power = 0;
		BigInteger currentChar;
		for (int i = end; i >= start; i--) {
			currentChar = BigInteger.valueOf((int) s.charAt(i));
			hash = hash.add(currentChar.multiply(BigInteger.valueOf(exponentiation(BASE.longValue(), power))).mod(MOD)).mod(MOD);
//			hash = hash.add(currentChar.multiply(BASE.pow(power).mod(MOD)).mod(MOD)).mod(MOD);
			power++;
		}

//		long endTime = System.currentTimeMillis();
//		System.out.println("getHash time = " + (endTime - startTime));
		return hash;
	}

	static long exponentiation(long base, long exp) 
    { 
		final long N = MOD.longValue();
        if (exp == 0) 
            return 1; 
  
        if (exp == 1) 
            return base % N; 
  
        long t = exponentiation(base, exp / 2); 
        t = (t * t) % N; 
  
        // if exponent is even value 
        if (exp % 2 == 0) 
            return t; 
  
        // if exponent is odd value 
        else
            return ((base % N) * t) % N; 
    } 
}
