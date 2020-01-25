package com.udemy.andrei.math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeFactors {

	public static void main(String[] args) {
		System.out.println(primeFactors(61));
	}

	public static Map<Long, Long> primeFactors(long n) {
		if (n < 2)
			throw new IllegalArgumentException("number must be greater than 1");

		Map<Long, Long> factors = new HashMap<>();

		long d = 2;
		long k;

		while (n > 1 || d * d < n) {
			k = 0;
			while (n % d == 0) {
				k++;
				n /= d;
			}
			if (k > 0)
				factors.put(d, k);
			d++;
		}

		if (n > 1) {
			factors.put(n, n);
		}

		return factors;
	}

	public static Map<Long, Long> primeFactorsFast(long n) {
		if (n < 2)
			throw new IllegalArgumentException("number must be greater than 1");

		Map<Long, Long> factors = new HashMap<>();

		long k = 0;
		long d = 2;

		while (n % d == 0) {
			k++;
			n /= d;
		}

		if (k > 0)
			factors.put(d, k);

		d = 5L;

		int[] increments = new int[] { 2, 4 };
		int incrIndex = 0;
		while (n > 1 || d * d < n) {
			k = 0;
			while (n % d == 0) {
				k++;
				n /= d;
			}
			if (k > 0)
				factors.put(d, k);

			d += increments[incrIndex];
			incrIndex = (incrIndex + 1) % 2;
		}

		if (n > 1) {
			factors.put(n, n);
		}

		return factors;
	}

	public static Map<Long, Long> primeFactorsWithSieves(long n) {
		if (n < 2)
			throw new IllegalArgumentException("number must be greater than 1");

		Map<Long, Long> factors = new HashMap<>();
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill((int) n);

		long k;
		for (Integer prime : primes) {
			k = 0;
			while (n % prime == 0) {
				k++;
				n /= prime;
			}
			
			if(k > 0) factors.put(1L*prime, k);
		}
		
		return factors;
	}
}
