package com.leetcode;

import java.math.BigInteger;

public class RepeatedStringMatch {
	final static int MOD = 1000_000_007;
	final static int BASE = 256;
	
	public static void main(String[] args) {
		RepeatedStringMatch solver = new RepeatedStringMatch();
		System.out.println(solver.repeatedStringMatch("a", "a"));
	}

	public int repeatedStringMatch(String A, String B) {
		if (A == null || B == null)
			return -1;
		if (B.length() < A.length())
			return -1;

		long hashASum = sum(getHash(A, 0, A.length() - 1));
		long[] hashSubStr = getHash(B, 0, A.length() - 1);

		int lenA = A.length();
		int lenB = B.length();
		int count = 0;

		for (int i = 0; i < (lenB - lenA); i++) {
			if (sum(hashSubStr) == hashASum && match(A, B, i))
				count++;
			hashSubStr = nextHash(hashSubStr, B, i);
		}

		if (count > 0)
			return count;
		return -1;
	}

	public static boolean match(String A, String B, int start) {
		for (int i = start, j = 0; i < (start + A.length()); i++, j++) {
			if (A.charAt(j) != B.charAt(i))
				return false;
		}
		return true;
	}

	public static long[] nextHash(long[] currentHash, String s, int start) {
		long[] newHash = new long[currentHash.length];

		// shift left by one
		for (int i = 0; i < newHash.length - 1; i++) {
			newHash[i] = (currentHash[i + 1] * BASE) % MOD;
		}

		newHash[newHash.length - 1] = (s.charAt(start + currentHash.length)) % MOD;
		return newHash;
	}

	public static long[] getHash(String s, int start, int end) {
		long[] hash = new long[end - start + 1];
		int pow = 0;
		for (int i = end; i >= start; i--) {
			hash[i] = ((long) (Math.pow(BASE, pow++) % MOD) * s.charAt(i)) % MOD;
		}
		return hash;
	}

	public static long sum(long[] hash) {
		long sum = 0L;
		for (int i = 0; i < hash.length; i++) {
			sum = (sum + hash[i]) % MOD;
		}
		return sum;
	}
	
}