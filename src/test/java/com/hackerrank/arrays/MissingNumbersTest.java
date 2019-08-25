package com.hackerrank.arrays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MissingNumbersTest {

	private MissingNumbers solver;

	@Before
	public void setUp() throws Exception {
		solver = new MissingNumbers();
	}

	@Test
	public void test01() {
		int[] original = { 7, 2, 5, 4, 6, 3, 5, 3 };
		int[] transported = { 7, 2, 5, 3, 5, 3 };
		int[] expected = { 4, 6 };
		int[] actual = solver.missingNumbers(transported, original);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test02() {
		int[] original = { 203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204 };
		int[] transported = { 203, 204, 205, 206, 207, 208, 203, 204, 205, 206 };
		int[] expected = { 204, 205, 206 };
		int[] actual = solver.missingNumbers(transported, original);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test03() {
		int[] original = { 11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12 };
		int[] transported = { 11,4,11,7,13,4,12,11,10,14 };
		int[] expected = { 3, 7, 8 ,10, 12};
		int[] actual = solver.missingNumbers(transported, original);
		assertArrayEquals(expected, actual);
	}

}
