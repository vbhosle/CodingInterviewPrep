package com.interviewbit.backtracking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PalindromePartitioningTest {

	PalindromePartitioning solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new PalindromePartitioning();
	}

	@Test
	public void emptyTest() {
		String input = "";
	    List<List<String>> expected = new ArrayList<>();
	    List<List<String>> actual = solver.partition(input);
	    assertThat(actual, is(expected));
	}
	
	@Test
	public void aTest() {
		String input = "a";
		List<List<String>> expected = Arrays.asList(Arrays.asList("a"));
		List<List<String>> actual = solver.partition(input);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void aabTest() {
		String input = "aab";
		List<List<String>> expected = Arrays.asList(Arrays.asList("a", "a", "b")
													,Arrays.asList("aa", "b")
													);
		List<List<String>> actual = solver.partition(input);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void aaaaTest() {
		String input = "aaaa";
		List<List<String>> expected = Arrays.asList(Arrays.asList("a", "a", "a", "a")
				,Arrays.asList("a", "a", "aa")
				,Arrays.asList("a", "aa", "a")
				,Arrays.asList("a", "aaa")
				,Arrays.asList("aa", "a", "a")
				,Arrays.asList("aa", "aa")
				,Arrays.asList("aaa", "a")
				,Arrays.asList("aaaa")
				);
		List<List<String>> actual = solver.partition(input);
		assertThat(actual, is(expected));
	}
	

	@Test(timeout=2500)
	public void performanceTest() {
		String input = "aaaaaaaaaa" + "aaaaaaaaaa";
		System.out.println("Performance, total combinations: " + solver.partition(input).size());
		
	}

}
