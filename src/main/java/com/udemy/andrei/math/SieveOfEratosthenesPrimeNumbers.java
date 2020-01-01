package com.udemy.andrei.math;

import java.util.Arrays;

public class SieveOfEratosthenesPrimeNumbers {

	public int countPrimes(int n) {
		boolean primes[] = new boolean[n];
		Arrays.fill(primes, true);

		int limit = (int) Math.sqrt(n);
		for (int i = 2; i <= limit; i++) {
			if (primes[i]) {
				for (int j = i * 2; j < n; j += i) {
					primes[j] = false;
				}
			}
		}

		int count = 0;

		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}
}
