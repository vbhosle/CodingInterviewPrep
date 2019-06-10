package com.interviewbit.backtracking;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class NumbersOfLengthNAndValueLessThanKTest {

	private NumbersOfLengthNAndValueLessThanK solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new NumbersOfLengthNAndValueLessThanK();
	}

	@Test
	public void test01() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 5));
		int length = 2;
		int limit = 21;
		int expected = 5;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test02() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 5));
		int length = 1;
		int limit = 2;
		int expected = 2;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}

	
	@Test
	public void test04() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0));
		int length = 1;
		int limit = 5;
		int expected = 1;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test05() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 7, 8, 9 ));
		int length = 9;
		int limit = 51822;
		int expected = 0;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test(timeout=100)
	public void test06() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 7, 9 ));
		int length = 5;
		int limit = 42950;
		int expected = 2592 ;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test07() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList( 0, 1, 2, 5 ));
		int length = 2;
		int limit = 40;
		int expected = 8 ;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
	

	@Test(timeout=1000)
	public void performance() {
		ArrayList<Integer> digits = new ArrayList<>(Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ));
		int length = 5;
		int limit = 99999;
		int expected = 89999 ;
		int actual = solver.solve(digits, length, limit);
		assertThat(actual, equalTo(expected));
	}
}
