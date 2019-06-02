package com.interviewbit.backtracking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubSetTest {

	private SubSet solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new SubSet();
	}

	@Test
	public void test01() {
		List<Integer> input = Arrays.asList(2);
		List<List<Integer>> expected = Arrays.asList(new ArrayList<>(), Arrays.asList(2));
		List<List<Integer>> actual = solver.subsets(input);
		assertThat(actual, is(expected));
	}

	@Test
	public void test02() {
		List<Integer> input = Arrays.asList(1, 2, 3);
		List<List<Integer>> expected = Arrays.asList(
				new ArrayList<>()
				, Arrays.asList(1)
				, Arrays.asList(1,2)
				, Arrays.asList(1,2,3)
				, Arrays.asList(1,3)
				, Arrays.asList(2)
				, Arrays.asList(2, 3)
				, Arrays.asList(3)
				);
		List<List<Integer>> actual = solver.subsets(input);
		assertThat(actual, is(expected));
	}
	

	@Test
	public void test03() {
		List<Integer> input = Arrays.asList(11, 12, 13);
		List<List<Integer>> expected = Arrays.asList(
				new ArrayList<>()
				, Arrays.asList(11)
				, Arrays.asList(11,12)
				, Arrays.asList(11,12,13)
				, Arrays.asList(11,13)
				, Arrays.asList(12)
				, Arrays.asList(12, 13)
				, Arrays.asList(13)
				);
		List<List<Integer>> actual = solver.subsets(input);
		assertThat(actual, is(expected));
	}

}
