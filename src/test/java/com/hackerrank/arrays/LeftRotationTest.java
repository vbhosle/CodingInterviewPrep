package com.hackerrank.arrays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeftRotationTest {

	private LeftRotation solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new LeftRotation();
	}

	@Test
	public void rotateByZeroTest() {
		int[] input = {1, 2, 3, 4, 5};
		int[] expected = {1, 2, 3, 4, 5};
		assertArrayEquals(expected, solver.rotateLeft(input, 0));
	}
	
	@Test
	public void rotateByOneTest() {
		int[] input = {1, 2, 3, 4, 5};
		int[] expected = {5, 1, 2, 3, 4};
		for (int i = 0; i < expected.length; i++) {
			System.out.println(expected[i]+" ");
		}
		assertArrayEquals(expected, solver.rotateLeft(input, 1));
	}
	
	@Test
	public void rotateByTwoTest() {
		int[] input = {1, 2, 3, 4, 5};
		int[] expected = {4, 5, 1, 2, 3};
		assertArrayEquals(expected, solver.rotateLeft(input, 2));
	}
	
	@Test
	public void rotateByArrayLengthTest() {
		int[] input = {1, 2, 3, 4, 5};
		int[] expected = {1, 2, 3, 4, 5};
		assertArrayEquals(expected, solver.rotateLeft(input, 5));
	}

}
