package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class LargestNumberFromIntListTest {

	private LargestNumberFromIntList solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new LargestNumberFromIntList();
	}

	@Test
	public void nullListReturnsEmpty() {
		assertThat(solver.largestNumber(null), equalTo(""));
	}
	
	@Test
	public void emptyListReturnsEmpty() {
		assertThat(solver.largestNumber(Collections.emptyList()), equalTo(""));
	}
	
	@Test
	public void _0_0_0_0Returns0() {
		assertThat(solver.largestNumber(Arrays.asList(0, 0, 0, 0)), equalTo("0"));
	}
	
	@Test
	public void _5Returns5() {
		assertThat(solver.largestNumber(Arrays.asList(5)), equalTo("5"));
	}
	
	@Test
	public void _3_30_34_5_9Returns9534330() {
		assertThat(solver.largestNumber(Arrays.asList(3, 30, 34, 5, 9)), equalTo("9534330"));
	}

	@Test
	public void _3_30_34_5_9_300Returns9534330300() {
		assertThat(solver.largestNumber(Arrays.asList(3, 30, 34, 5, 9, 300)), equalTo("9534330300"));
	}
	
	@Test
	public void _0_0_10_100_1000Returns10100100000() {
		assertThat(solver.largestNumber(Arrays.asList(0, 0, 10, 100, 1000)), equalTo("10100100000"));
	}
	
	@Test
	public void _2147483647_2147483647Returns21474836472147483647() {
		assertThat(solver.largestNumber(Arrays.asList(2147483647, 2147483647)), equalTo("21474836472147483647"));
	}

}
