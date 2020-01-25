package com.udemy.andrei.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesPrimeNumbers {

	public static List<Integer> primeNumbersTill(int limit) {
		List<Integer> primes = new ArrayList<>();

		boolean[] isPrime = new boolean[limit + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		int sqrtLimit = (int) Math.sqrt(limit);
		for (int i = 2; i <= sqrtLimit; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= limit; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for(int i = 2; i <= limit; i++) {
			if(isPrime[i]) primes.add(i);
		}
		
		return primes;
	}
}
