package com.hackerrank.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hackerrank.arrays.ArrayManipulation;

public class ArrayManipulationTest {

	private ArrayManipulation solver;
	
	@Before
	public void setup() {
		solver = new ArrayManipulation();
	}
	
	@Test
	public void test1() {
		int[][] queries = new int[][] {
			{ 1, 5, 3},
			{ 4, 8, 7},
			{ 6, 9, 1}
		};
		
		assertThat(solver.arrayManipulation(10, queries), equalTo(10L));
	}
	
	@Test
	public void test2() {
		int[][] queries = new int[][] {
			{1, 2, 100},
			{2, 5, 100},
			{3, 4, 100}
		};
		
		assertThat(solver.arrayManipulation(10, queries), equalTo(200L));
	}

}
