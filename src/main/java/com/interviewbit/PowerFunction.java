package com.interviewbit;

// Read https://discuss.codechef.com/t/a-tutorial-on-fast-modulo-multiplication-exponential-squaring/2899
// https://dev.to/maurobringolf/a-neat-trick-to-compute-modulo-of-negative-numbers-111e
public class PowerFunction {

	public int pow(int x, int n, int d) {
		if (x == 0)
			return x;
		if (n == 0)
			return 1;
		
		long base = x;
		long result = 1;

		while (n > 0) {
			if (n % 2 != 0) {
				result = (result * base) % d;
			}

			n = n >> 1;
			base = (base%d * base%d) % d;
		}

		if (result < 0)
			result = result + d;
		return (int) result;
	}
}
