package com.hackerrank.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixTest {

	SpiralMatrix solver;

	@Before
	public void setUp() throws Exception {
		solver = new SpiralMatrix();
	}

	@Test
	public void testEvenSqareMatrix() {
		int[][] data = new int[][] { { 1, 2, 3, 4 },
									 { 12, 13, 14, 5 }, 
									 { 11, 16, 15, 6 }, 
									 { 10, 9, 8, 7 } 
									};
		List<Integer> actual = solver.traverseSpiral(data);
//		System.out.println(actual.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
		assertThat(actual, equalTo(IntStream.range(1, 17).collect(ArrayList::new, List::add, List::addAll)));
	}
	
	@Test
	public void testOddSqareMatrix() {
		int[][] data = new int[][] { { 1, 2, 3, 4, 5 },
									 { 16, 17, 18, 19, 6 }, 
									 { 15, 24, 25, 20, 7 }, 
									 { 14, 23, 22, 21, 8 }, 
									 { 13, 12, 11, 10, 9} 
									};
		List<Integer> actual = solver.traverseSpiral(data);
		assertThat(actual, equalTo(IntStream.range(1, 26).collect(ArrayList::new, List::add, List::addAll)));
	}
	
	@Test
	public void testNonSqareMatrix() {
		int[][] data = new int[][] { { 1, 2, 3, 4, 5 },
									 { 14, 15, 16, 17, 6 }, 
									 { 13, 20, 19, 18, 7 }, 
									 { 12, 11, 10, 9, 8 } 
									};
		List<Integer> actual = solver.traverseSpiral(data);
		assertThat(actual, equalTo(IntStream.range(1, 21).collect(ArrayList::new, List::add, List::addAll)));
	}
	
	@Test
	public void testSingleElementMatrix() {
		int[][] data = new int[][] { {1}
									};
		List<Integer> actual = solver.traverseSpiral(data);
		assertThat(actual, equalTo(Arrays.asList(1)));
	}


}
