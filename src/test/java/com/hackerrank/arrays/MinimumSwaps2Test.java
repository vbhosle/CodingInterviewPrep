package com.hackerrank.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimumSwaps2Test {

	private MinimumSwaps2 solver;

	@Before
	public void setup() {
		solver = new MinimumSwaps2();
	}

	@Test
	public void nullReturns0() {
		assertThat(solver.minimumSwaps(null), equalTo(0));
	}

	@Test
	public void emptyReturns0() {
		assertThat(solver.minimumSwaps(new int[0]), equalTo(0));
	}

	@Test
	public void singleReturns0() {
		assertThat(solver.minimumSwaps(new int[] { 1 }), equalTo(0));
	}

	@Test
	public void fiveSwaps() {
		assertThat(solver.minimumSwaps(new int[] { 7, 1, 3, 2, 4, 5, 6 }), equalTo(5));
	}
	
	@Test
	public void threeSwaps1() {
		assertThat(solver.minimumSwaps(new int[] {4, 3, 1, 2}), equalTo(3));
	}
	
	@Test
	public void threeSwaps2() {
		assertThat(solver.minimumSwaps(new int[] {1, 3, 5, 2, 4, 6, 7}), equalTo(3));
	}

}
