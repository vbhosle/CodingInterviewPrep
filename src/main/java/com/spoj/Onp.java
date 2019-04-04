package com.spoj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//ACCEPTED!!!!!
public class Onp {

	private static final Map<Character, Integer> precedence = new HashMap<>();

	static {
		precedence.put('+', 0);
		precedence.put('-', 0);
		precedence.put('*', 1);
		precedence.put('/', 1);
		precedence.put('^', 2);
	}

	public String infixTopostfix(String infix) {
		if (infix == null || infix.length() == 0)
			return "";

		Deque<Character> stack = new ArrayDeque<>();
		int len = infix.length();

		StringBuffer strBuffer = new StringBuffer(infix.length());

		char currentChar;
		for (int i = 0; i < len; i++) {
			currentChar = infix.charAt(i);
			if (currentChar >= 'a' && currentChar <= 'z') {
				strBuffer.append(currentChar);
			} 
			else if (precedence.containsKey(currentChar)) {
				while (!stack.isEmpty() && !isOpeningParantheses(stack.peek())
						&& hasHigherPrecedence(stack.peek(), currentChar)) {
					strBuffer.append(stack.pop());
				}
				stack.push(currentChar);
			}
			else if(isOpeningParantheses(currentChar)) {
				stack.push(currentChar);
			}
			else if(isClosingParantheses(currentChar)) {
				while(!stack.isEmpty() && !isOpeningParantheses(stack.peek())) {
					strBuffer.append(stack.pop());
				}
				stack.pop();
			}
		}
		
		
		while(!stack.isEmpty()) {
			currentChar = stack.pop();
			if(precedence.containsKey(currentChar)) {
				strBuffer.append(currentChar);
			}
		}
		
		return strBuffer.toString();
	}

	private static boolean isOpeningParantheses(char ch) {
		return "({".indexOf(ch) != -1;
	}

	private static boolean isClosingParantheses(char ch) {
		return "})".indexOf(ch) != -1;
	}

	private static boolean hasHigherPrecedence(Character operator1, Character operator2) {
		return precedence.get(operator1) >= precedence.get(operator2);
	}

}
