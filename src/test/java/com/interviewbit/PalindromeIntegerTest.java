package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalindromeIntegerTest {

	private PalindromeInteger solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new PalindromeInteger();
	}

	@Test
	public void test121() {
		assertThat(solver.isPalindrome(121), equalTo(1));
	}
	
	@Test
	public void test2147447412() {
		assertThat(solver.isPalindrome(2147447412), equalTo(1));
	}
	
	@Test
	public void test1234() {
		assertThat(solver.isPalindrome(1234), equalTo(0));
	}

}
