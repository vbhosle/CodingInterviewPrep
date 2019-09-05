package com.codechef.foundation.stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codechef.foundation.stack.MaximumXorSecondary;

public class MaximumXorSecondaryTest {

	private MaximumXorSecondary solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new MaximumXorSecondary();
	}

	@Test
	public void test01() {
		List<Integer> list = Arrays.asList(5, 2, 1, 4, 3);
		int expected = 7;
		int actual = solver.maxXor(list);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test02() {
		List<Integer> list = Arrays.asList(9, 8, 3, 5, 7);
		int expected = 15;
		int actual = solver.maxXor(list);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test03() {
		List<Integer> list = Arrays.asList(5, 1, 2, 4 , 6);
		int expected = 7;
		int actual = solver.maxXor(list);
		assertThat(actual, equalTo(expected));
	}

}
