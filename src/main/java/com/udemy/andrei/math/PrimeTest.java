package com.udemy.andrei.math;

public class PrimeTest {
	
	public static boolean isPrimeFaster(long n) {
		if (n == 0 || n == 1)
			return false;
		
		if (n <= 3)
			return true;
		
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		
		long limit = (long) Math.ceil(Math.sqrt(n));
		
		for (long i = 5; i <= limit; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		
		long limit = (long) Math.sqrt(n);
		
		for (long i = 2; i <= limit; i++)
			if (n % i == 0)
				return false;

		return true;
	}
}
