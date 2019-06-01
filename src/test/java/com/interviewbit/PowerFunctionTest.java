package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PowerFunctionTest {

	private PowerFunction solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new PowerFunction();
	}

	@Test
	public void twoToPowerFourTest() {
		assertThat(solver.pow(2, 4, 100), equalTo(16));
	}
	
	@Test
	public void twoToPowerFiveTest() {
		assertThat(solver.pow(2, 5, 100), equalTo(32));
	}
	
	@Test
	public void givenTest01() {
		assertThat(solver.pow(-1, 1, 20), equalTo(19));
	}
	
	@Test
	public void givenTest02() {
		assertThat(solver.pow(71045970, 41535484, 64735492), equalTo(20805472));
	}

}
