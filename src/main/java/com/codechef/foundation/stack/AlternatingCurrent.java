package com.codechef.foundation.stack;

import java.io.*;
import java.util.*;

public class AlternatingCurrent {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		System.out.println(canUntangle(input));
		reader.close();
	}

	public static String canUntangle(String input) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(input.charAt(i));
			} else {
				if (stack.peek() == input.charAt(i)) {
					stack.pop();
				} else {
					stack.push(input.charAt(i));
				}
			}
		}

		return stack.isEmpty() ? "Yes" : "No";
	}
}