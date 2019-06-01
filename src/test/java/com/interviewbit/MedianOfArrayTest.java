package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MedianOfArrayTest {
	private MedianOfArray solver;

	@Before
	public void setUp() throws Exception {
		solver = new MedianOfArray();
	}

	@Ignore
	@Test
	public void firstArrayIsNull() {
		List<Integer> a = null;
		List<Integer> b = Arrays.asList(10, 20, 30);
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(20.0));
	}
	
	@Ignore
	@Test
	public void secondArrayIsNull() {
		List<Integer> a = Arrays.asList(10, 20, 30);
		List<Integer> b = null;
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(20.0));
	}
	
	@Test
	public void givenTest01() {
		List<Integer> a = Arrays.asList(-50, -41, -40, -19, 5, 21, 28);
		List<Integer> b = Arrays.asList(-50, -21, -10);
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(-20.0));
	}
	
	@Test
	public void givenTest02() {
		List<Integer> a = Arrays.asList(0, 23);
		List<Integer> b = Collections.emptyList();
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(11.5));
	}
	

	@Test
	public void simpleTest() {
		List<Integer> a = Arrays.asList(5, 10, 15, 20);
		List<Integer> b = Arrays.asList(2, 8, 12);
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(10.0));
	}
	
	@Test(timeout=500)
	public void performance() {
		List<Integer> a = IntStream.range(-100000, 0).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		List<Integer> b = IntStream.range(0, 100001).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		assertThat(solver.findMedianSortedArrays(a, b), equalTo(0.0));
	}

}
