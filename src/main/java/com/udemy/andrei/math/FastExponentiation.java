package com.udemy.andrei.math;

public class FastExponentiation {

	private static long MOD = 1000_000_007;

	public static void main(String[] args) {
		assert (recursive(5, 13, MOD) == 220703118L) : "recursive test failed!";
		assert (iterative(5, 13, MOD) == 220703118L) : "recursive test failed!";
	}

	public static long recursive(long base, long power, long mod) {
		if (power == 0)
			return 1;
		
		if (base % 2 == 0) {
			return recursive((base * base) % mod, power / 2, mod);
		}

		return (base * recursive(base, power - 1, mod)) % mod;
	}
	
	public static long iterative(long base, long power, long mod) {
		if (power == 0)
			return 1;
		
		long ans = 1;
		
		while(power > 0) {
			if(base % 2 == 0) {
				base = (base * base) % mod;
				power = power/2;
			}
			else {
				ans = (ans * base) % mod;
				power = power - 1;
			}
		}
		
		return ans % mod;
	}
	
	
}
