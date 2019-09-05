package com.codechef.foundation.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestRegularBracketSequenceTest {

	@Test
	public void test01() {
		String input = ")((())))(()())";
		String expected = "6 2";
		String actual = LongestRegularBracketSequence.longestSequence(input);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test02() {
		String input = "))(";
		String expected = "0 1";
		String actual = LongestRegularBracketSequence.longestSequence(input);
		assertThat(actual, equalTo(expected));
	}

}
