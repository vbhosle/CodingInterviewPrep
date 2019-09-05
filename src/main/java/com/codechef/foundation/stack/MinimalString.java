package com.codechef.foundation.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

//https://codeforces.com/contest/797/problem/C
public class MinimalString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new MinimalString().playGame(br.readLine()));
	}

	public String playGame(String s) {
		// keep count of all characters in sorted orders. It tells which character to expect next to have lexicographically minimal string
		TreeMap<Character, Integer> charCounts = new TreeMap<>();
		for (char ch : s.toCharArray()) {
			charCounts.merge(ch, 1, (old, neww) -> old + 1);
		}

		Deque<Character> t = new LinkedList<>();
		StringBuilder u = new StringBuilder(s.length());

		char nextChar = charCounts.firstKey();
		for (int i = 0; i < s.length(); i++) {
			
			// push to t hides the previous top
			if(!t.isEmpty()) {
				charCounts.merge(t.peek(), -1, (old, neww) -> (old + neww) == 0? null : (old + neww));
			}
			
			t.push(s.charAt(i));
			
			if(!t.isEmpty() && nextChar == t.peek()) {
				while(!t.isEmpty() && nextChar == t.peek()) {
					u.append(t.peek());
					charCounts.merge(t.peek(), -1, (old, neww) -> (old + neww) == 0? null : (old + neww));
					t.pop();
					
					if(!t.isEmpty()) {
						// pop un-hides the character below it
						charCounts.merge(t.peek(), 1, (old, neww) -> old + neww);
					}
					
					if(charCounts.isEmpty()) break;
					
					//update nextChar
					nextChar = charCounts.firstKey();
				}
			}
		}
		
		// add remaining characters
		while (!t.isEmpty()) {
			u.append(t.pop());
		}

		return u.toString();
	}
}
