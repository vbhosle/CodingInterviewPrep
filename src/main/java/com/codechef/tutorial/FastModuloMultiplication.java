package com.codechef.tutorial;

public class FastModuloMultiplication {

	long fast_exp(int base, int exp, int mod) {
		long base1;
		if (exp == 1)
			return base % mod;
		else {
			if (exp % 2 == 1) {
				base1 = base * fast_exp(base * base, (exp - 1) / 2, mod);
				if (base1 >= mod)
					return base1 % mod;
				return base1;
			} else {
				base1 = fast_exp(base * base, exp / 2, mod);
				if (base1 >= mod)
					return base1 % mod;
				return base1;
			}
		}
	}

	long fast_exp_of_two(int base, int exp, int mod) {
		long result = 1;
		while (exp > 0) {
			if (exp % 2 == 1)
				result = (result * base) % mod;
			base = (base * base) % mod;
			exp /= 2;
		}
		return result;
	}
}
