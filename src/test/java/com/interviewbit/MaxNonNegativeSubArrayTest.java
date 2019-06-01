package com.interviewbit;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MaxNonNegativeSubArrayTest {

	private MaxNonNegativeSubArray solver;

	@Before
	public void setUp() throws Exception {
		solver = new MaxNonNegativeSubArray();
	}

	@Test
	public void givenTest() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 3));
		assertThat(solver.maxset(input), is(Arrays.asList(1, 2, 5)));
	}

	@Test
	public void givenTest2() {
		ArrayList<Integer> input = new ArrayList<>(
				Arrays.asList(756898537, -1973594324, -2038664370, -184803526, 1424268980));
		assertThat(solver.maxset(input), is(Arrays.asList(1424268980)));
	}

	@Test
	public void givenTest3() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0, 0, -1, 0));
		assertThat(solver.maxset(input), is(Arrays.asList(0, 0)));
	}
	
	@Test
	public void givenTest4() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671));
		assertThat(solver.maxset(input), is(Arrays.asList(41594 ,16395, 19113, 71006 )));
	}

	@Test
	public void singlePositiveTest() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-846930886, -1714636915, 424238335, -1649760492));
		solver.maxset(input).forEach(System.out::println);
		assertThat(solver.maxset(input), is(Arrays.asList(424238335)));
	}

	@Test
	public void allNegative() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-1, -2, -5, -7, -2, -3));
		assertThat(solver.maxset(input), is(empty()));
	}

	@Test
	public void equalSumButMaxLength() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 5, -5, 1, 2, 3, 2));
		assertThat(solver.maxset(input), is(Arrays.asList(1, 2, 3, 2)));
	}

	@Test
	public void equalSumEqualLengthMinFirst() {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 3, -5, 0, 3, 3, 2));
		assertThat(solver.maxset(input), is(Arrays.asList(1, 2, 2, 3)));
	}

}
