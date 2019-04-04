package com.leetcode.easy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.PowerOfFour;

public class PowerOfFourTest {

	private PowerOfFour solver;
	
	@Before
	public void setup() {
		solver = new PowerOfFour();
	}
	
	@Test
	public void powersOfFour() {
		assertThat(solver.isPowerOfFour(1), equalTo(true));
		assertThat(solver.isPowerOfFour(4), equalTo(true));
		assertThat(solver.isPowerOfFour(16), equalTo(true));
		assertThat(solver.isPowerOfFour(64), equalTo(true));
	}
	
	@Test
	public void notPowersOfFour() {
		assertThat(solver.isPowerOfFour(0), equalTo(false));
		assertThat(solver.isPowerOfFour(2), equalTo(false));
		assertThat(solver.isPowerOfFour(3), equalTo(false));
		assertThat(solver.isPowerOfFour(5), equalTo(false));
		assertThat(solver.isPowerOfFour(20), equalTo(false));
		assertThat(solver.isPowerOfFour(32), equalTo(false));
		assertThat(solver.isPowerOfFour(-64), equalTo(false));
	}

}
