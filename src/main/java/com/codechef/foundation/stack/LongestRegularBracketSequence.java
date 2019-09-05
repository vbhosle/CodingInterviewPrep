package com.codechef.foundation.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LongestRegularBracketSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestSequence(final String expression) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int[] d = new int[expression.length()];
		int[] c = new int[expression.length()];

		for (int i = 0; i < expression.length(); i++) {
			d[i] = Integer.MAX_VALUE;
			c[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					d[i] = stack.peek();
					c[i] = stack.peek();
					stack.pop();
					c[i] = Math.min(c[d[i] - 1], c[i]);
					// AS LEFT AS POSSIBLE WILL BE THE LONGEST
					// CHAR AR J-1 CAN BE ( ALSO IN THAT CASE IT WILL GIVE INT_MAX , SOO
					// WILL NOT INCLUDED
				}
			} else {
				stack.push(i);
			}
		}

		int ans = 0, count = 1;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ')') {
				if (i - c[i] + 1 > ans) {
					ans = i - c[i] + 1;
					count = 1;
				} else if (i - c[i] + 1 == ans) {
					count++;
				}
			}
		}
		
		if(ans == 0) return "0 1";
		return ans + " " + count;

	}

}
