package com.hackerrank.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompilerTest {

	private Compiler solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new Compiler();
	}

	@Test
	public void nullOrEmptyReturnsZero() {
		assertThat(solver.validPrefixlength(null), equalTo(0));
		assertThat(solver.validPrefixlength(""), equalTo(0));
	}
	
	@Test
	public void fourMatchingTest1() {
		assertThat(solver.validPrefixlength("<<>>"), equalTo(4));
	}
	
	@Test
	public void fourMatchingTest2() {
		assertThat(solver.validPrefixlength("<<>><<>"), equalTo(4));
	}
	
	@Test
	public void sixMatching() {
		assertThat(solver.validPrefixlength("<<><>>"), equalTo(6));
	}
	
	@Test
	public void zeroMatchingTest1() {
		assertThat(solver.validPrefixlength("><"), equalTo(0));
		assertThat(solver.validPrefixlength("<<<<"), equalTo(0));
	}
	

	@Test
	public void zeroMatchingTest2() {
		assertThat(solver.validPrefixlength("<<>"), equalTo(0));
	}

	@Test
	public void twoMatching() {
		assertThat(solver.validPrefixlength("<>>>"), equalTo(2));
	}
}
