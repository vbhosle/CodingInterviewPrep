package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MatrixSearchTest {

	private MatrixSearch solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new MatrixSearch();
	}

	@Test
	public void rowBinarySearchTest1() {
		List<List<Integer>> matrix = Arrays.asList(
											Arrays.asList(1, 3, 5, 7),
											Arrays.asList(10, 11, 16, 20),
											Arrays.asList(23, 30, 34, 50)
										);
		assertThat(solver.rowBinarySearch(matrix, 11), equalTo(1));
	}
	
	@Test
	public void rowBinarySearchTest2() {
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(1, 3, 5, 7),
				Arrays.asList(10, 11, 16, 20),
				Arrays.asList(23, 30, 34, 50)
				);
		assertThat(solver.rowBinarySearch(matrix, 7), equalTo(0));
	}
	
	@Test
	public void rowBinarySearchTest3() {
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(1, 3, 5, 7),
				Arrays.asList(10, 11, 16, 20),
				Arrays.asList(23, 30, 34, 50)
				);
		assertThat(solver.rowBinarySearch(matrix, 23), equalTo(2));
	}
	
	@Test
	public void rowBinarySearchTest4() {
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(1, 3, 5, 7),
				Arrays.asList(10, 11, 16, 20),
				Arrays.asList(23, 30, 34, 50)
				);
		assertThat(solver.rowBinarySearch(matrix, 100), equalTo(-1));
	}
	

	@Test
	public void rowBinarySearchTest5() {
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(1, 3, 5, 7),
				Arrays.asList(10, 11, 16, 20),
				Arrays.asList(23, 30, 34, 50)
				);
		assertThat(solver.rowBinarySearch(matrix, 0), equalTo(-1));
	}

}
