package com.codechef.tutorial;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FastModuloMultiplicationTest {

	private FastModuloMultiplication solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new FastModuloMultiplication();
	}

	@Test
	public void TwoToAnyPowerModTwoReturnsZero() {
		assertThat(solver.fast_exp(2, 4, 2), equalTo(0L));
//		assertThat(solver.fast_exp(2, 3, 2), equalTo(0L));
//		assertThat(solver.fast_exp(2, 2, 2), equalTo(0L));
//		assertThat(solver.fast_exp(2, 1, 2), equalTo(0L));
	}
	
	@Test
	public void fast_exp_of_twoTest() {
		assertThat(solver.fast_exp_of_two(2, 4, 2), equalTo(0L));
//		assertThat(solver.fast_exp_of_two(2, 3, 2), equalTo(0L));
//		assertThat(solver.fast_exp_of_two(2, 2, 2), equalTo(0L));
//		assertThat(solver.fast_exp_of_two(2, 1, 2), equalTo(0L));
	}

}
