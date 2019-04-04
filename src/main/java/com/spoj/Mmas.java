package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//ACCEPTED
public class Mmas {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new Mmas().getMolecularMassOf(reader.readLine()));
		reader.close();
	}
	
	public int getMolecularMassOf(String formula) {
		if(formula == null || formula.length() == 0) return 0;
		int mass = 0;
		int len = formula.length();
		Deque<String> stack = new ArrayDeque<>(formula.length());

		int tempSum;
		char currentElement;
		for (int i = 0; i < len; i++) {
			currentElement = formula.charAt(i);
			if (!stack.isEmpty() && stack.peek().equals(")")) {
				tempSum = 0;
				stack.pop(); //")"
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					tempSum += Integer.parseInt(stack.pop());
				}
				stack.pop(); // '('
				stack.push("" + tempSum);
			}

			if ("CHO".indexOf(currentElement) != -1) {
				stack.push(getMassOf(currentElement));
			}
			else if("()".indexOf(currentElement) != -1) {
				stack.push(""+currentElement);
			}
			else {
				//number
				stack.push(""+(Integer.parseInt(stack.pop())*Integer.parseInt(""+currentElement)));
			}
		}
		
		mass = 0;
		while (!stack.isEmpty()) {
			if("()".indexOf(stack.peek()) == -1) {				
				mass += Integer.parseInt(stack.peek());
			}
			stack.pop();
		}
		return mass;
	}

	private static String getMassOf(char atom) {
		switch (atom) {
		case 'C':
			return "12";
		case 'O':
			return "16";
		case 'H':
			return "1";
		}
		return "0";
	}
}
