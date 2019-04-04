package com.crackingthecodinginterview.stringmanipulation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MakingAnagramsTest {

	private MakingAnagrams solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new MakingAnagrams();
	}

	@Test
	public void noDifferences() {
		String a = "abcd";
		String b = "dbca";
		assertThat(solver.makeAnagram(a, b), equalTo(0));
	}
	
	@Test
	public void oneDifferences1() {
		String a = "abcd";
		String b = "dbcae";
		assertThat(solver.makeAnagram(a, b), equalTo(1));
	}
	
	@Test
	public void oneDifferences2() {
		String a = "abcde";
		String b = "dbca";
		assertThat(solver.makeAnagram(a, b), equalTo(1));
	}
	
	@Test
	public void threeDifferences1() {
		String a = "aabbb";
		String b = "ab";
		assertThat(solver.makeAnagram(a, b), equalTo(3));
	}
	
	@Test
	public void threeDifferences2() {
		String a = "ab";
		String b = "aabbb";
		assertThat(solver.makeAnagram(a, b), equalTo(3));
	}

}
