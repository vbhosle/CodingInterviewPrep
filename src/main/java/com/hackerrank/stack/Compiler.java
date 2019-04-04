package com.hackerrank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compiler {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(reader.readLine());
		Compiler solver = new Compiler();
		for (int i = 1; i <= T; i++) {
			System.out.println(solver.validPrefixlength(reader.readLine()));
		}
	}

	public int validPrefixlength(String expression) {
		if (expression == null || expression.length() == 0)
			return 0;
		int t = 0;
		int ans = 0;
		int len = expression.length();
		for (int i = 0; i < len; i++) {
			if (expression.charAt(i) == '<') {
				t++;
			} else {
				t--;
				if (t == 0) {
					ans = Math.max(ans, i + 1);
				}
				if (t == -1)
					break;
			}
		}
		return ans;
	}
}
