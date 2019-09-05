package com.codechef.foundation.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// http://codeforces.com/contest/281/problem/D
public class MaximumXorSecondary {

	public int maxXor(List<Integer> list) {
		if (list == null || list.size() < 1)
			throw new IllegalArgumentException("Minimum two elements required");

		int max = Integer.MIN_VALUE;
		int i = 0;

		// push first element
		Deque<Integer> stack = new LinkedList<>(); // monotonically decreasing stack
		stack.push(list.get(i++));

		while (i < list.size()) {
			if (!stack.isEmpty())
				max = Math.max(max, list.get(i) ^ stack.peek()); // xor with top
			if (!stack.isEmpty() && list.get(i) > stack.peek()) {
				// violation of monotonically decreasing sequence, thus pop.
				// it also means new element can be a new maximum or second maximum element in
				// new subarray
				stack.pop();
				continue;
			} else {
				stack.push(list.get(i));
				i++;
			}
		}

		return max;
	}
}
