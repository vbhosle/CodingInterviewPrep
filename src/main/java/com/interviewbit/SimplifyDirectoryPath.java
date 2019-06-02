package com.interviewbit;

import java.util.Stack;

public class SimplifyDirectoryPath {

	public String simplifyPath(String A) {
		if (A == null || A.isEmpty())
			return "/";

		Stack<String> stack = new Stack<>();
		String[] directory = A.split("/");
		String c;
		for (int i = 1; i < directory.length; i++) {
			c = directory[i];
			switch (c) {
			case ".":
			case "":
				break;
			case "..":
				if (!stack.isEmpty())
					stack.pop();
				break;
			default:
				stack.push(c);
			}
		}

		if (stack.isEmpty())
			return "/";

		StringBuilder sb = new StringBuilder();
		for (String name: stack) {
			sb.append("/");
			sb.append(name);
		}

		return sb.toString();

	}
}
