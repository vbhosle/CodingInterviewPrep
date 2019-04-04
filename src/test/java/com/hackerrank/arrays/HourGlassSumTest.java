package com.hackerrank.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hackerrank.arrays.HourGlassSum;

public class HourGlassSumTest {

	private HourGlassSum solver;
	
	@Before
	public void setup() {
		solver = new HourGlassSum();
	}
	
	@Test
	public void testExample1() {
		int[][] input = new int[][] {
				{-9, -9, -9, 1, 1, 1}, 
				{ 0, -9,  0, 4, 3, 2},
				{-9, -9, -9, 1, 2, 3},
				{ 0,  0,  8, 6, 6, 0},
				{ 0,  0,  0,-2, 0, 0},
				{ 0,  0,  1, 2, 4, 0}
				};
		assertThat(solver.hourglassSum(input), equalTo(28));
	}
	
	@Test
	public void testExample2() {
		int[][] input = new int[][] {
				{ 1, 1, 1, 0, 0, 0}, 
				{ 0, 1, 0, 0, 0, 0},
				{ 1, 1, 1, 0, 0, 0},
				{ 0, 0, 2, 4, 4, 0},
				{ 0, 0, 0, 2, 0, 0},
				{ 0, 0, 1, 2, 4, 0}
				};
		assertThat(solver.hourglassSum(input), equalTo(19));
	}

}
