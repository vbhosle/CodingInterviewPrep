package com.codechef.foundation.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MinimumReversal {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		while (testcases > 0) {
			System.out.println(minReplaceToBalance(br.readLine()));
			testcases--;
		}

		br.close();
	}

	public static int minReplaceToBalance(String expression) {
		if (expression == null || expression.length() % 2 == 1)
			return -1;
		Deque<Character> stack = new LinkedList<>();
		int i = 0;
		char current;
		// remove valid expressions
		while (i < expression.length()) {
			current = expression.charAt(i++);
			if (stack.isEmpty() || current == '{') {
				stack.push(current);
			} else if (current == '}') {
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(current);
				}
			}
		}

		// remaining expression is always of the form }}}... {{..
		int opening = 0;
		int closing = 0;
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (current == '{') {
				opening++;
			} else {
				closing++;
			}
		}

		return (int) (Math.ceil(opening / 2) + Math.ceil(closing / 2));
	}

}
