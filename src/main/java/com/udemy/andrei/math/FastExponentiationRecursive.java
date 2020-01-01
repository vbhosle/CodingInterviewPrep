package com.udemy.andrei.math;

// https://www.codechef.com/problems/FEXP
public class FastExponentiationRecursive {

	private static final int MOD = 1000_000_007;
	
	public static void main(String[] args) {
		assert (moduloExponentiationRecursive(5, 13) == 220703118L):"recursive test failed!";
		assert (moduloExponentiation(5, 13) == 220703118L):"iterative test failed!";
	}
	
	public static long moduloExponentiationRecursive(long base, int power) {
		if(power == 0) return 1;
		if(power == 1) return base;
		if(power % 2 == 0) return moduloExponentiation((base*base)%MOD, power/2);
		return (base * moduloExponentiation(base, power-1)) % MOD;
	}
	
	public static long moduloExponentiation(long base, int power) {
		long ans = 1;
		while(power != 0) {
			if(power % 2 == 0) {
				power = power / 2;
				base = (base*base) % MOD;
			}
			else {
				ans = (ans * base) % MOD;
				power = power - 1;
			}
		}
		
		return ans;
	}
}
