package com.leetcode;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		if (num == 1)
			return true;
		if (num <= 0 || num % 4 != 0)
			return false;

		String binary = Integer.toBinaryString(num);
		int indexOfOne = binary.indexOf('1');
		int lastIndexOfOne = binary.lastIndexOf('1');
		if ((indexOfOne == lastIndexOfOne) && (indexOfOne) == 0 && (binary.length()) % 2 == 1)
			return true;

		return false;

	}

	public boolean isPowerOfFourFast(int num) {
		int x = num & (num - 1); // x = 0 if the num is power of 2
		if (num > 0 && x == 0) {
			// doing left shift, diving the number by 2
			// so we do left shift twice, i.e. divive the number by 4 every time. if the
			// number is finally 1, then its a power of 4 else not
			// alternate approach
			// consider the case when num = 8, the and of 8 and 7 will give 0, but there are
			// odd number of zeroes in 8.
			// so we need to count the number of zeroes.
			while (num > 1) {
				num >>= 2;
				// count++;
			}

		}
		return (num == 1) ? true : false;
	}

	public boolean isPowerOfFourRecursive(int num) {
		if (num == 0)
			return false;
		if (num == 1)
			return true;
		return num % 4 == 0 && isPowerOfFourRecursive(num / 4);
	}

	public boolean isPowerOfFourOneLiner(int num) {
		return Integer.bitCount(num) == 1 && (Integer.toBinaryString(num).length() - 1) % 2 == 0;
	}
}
