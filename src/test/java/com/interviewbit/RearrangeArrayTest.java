package com.interviewbit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RearrangeArrayTest {

	private RearrangeArray solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new RearrangeArray();
	}

	@Test
	public void test01() {
		List<Integer> input = new ArrayList<>();
		List<Integer> expected = Arrays.asList(0, 1, 2, 3);
		input.add(3);
		input.add(2);
		input.add(1);
		input.add(0);
		solver.arrange(input);
		assertThat(input, is(expected));
	}
	

	@Test
	public void test02() {
		List<Integer> input = new ArrayList<>();
		List<Integer> expected = Arrays.asList(3, 2, 1, 0);
		input.add(1);
		input.add(3);
		input.add(0);
		input.add(2);
		solver.arrange(input);
		assertThat(input, is(expected));
	}

}
