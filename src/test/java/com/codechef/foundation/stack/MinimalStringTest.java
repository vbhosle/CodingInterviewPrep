package com.codechef.foundation.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimalStringTest {

	private MinimalString solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new MinimalString();
	}

	@Test
	public void test01() {
		String s = "cab";
		String expected = "abc";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test02() {
		String s = "acdb";
		String expected = "abdc";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test03() {
		String s = "dcba";
		String expected = "abcd";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test04() {
		String s = "bdcbe";
		String expected = "bbcde";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test05() {
		String s = "bdbfc";
		String expected = "bbcfd";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test06() {
		String s = "bnrdfnybkzepmluyrhofwnwvfmkdwolvyzrqhuhztvlwjldqmoyxzytpfmrgouymeupxrvpbesyxixnrfbxnqcwgmgjstknqtwrr";
		String expected = "bbbbcggjknqrrwttsmwqnxfrnxixysepvrxpuemyuogrmfptyzxyomqdljwlvtzhuhqrzyvlowdkmfvwnwfohryulmpezkynfdrn";
		String actual = solver.playGame(s);
		assertThat(actual, equalTo(expected));
	}

}
