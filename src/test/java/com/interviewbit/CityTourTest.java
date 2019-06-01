package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CityTourTest {

	private CityTour solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new CityTour();
	}

	@Test
	public void givenTest01() {
		assertThat(solver.solve(10, Arrays.asList(7, 5, 9, 3, 10, 2, 4, 8, 6)), equalTo(1));
	}
	
	@Test
	public void givenTest02() {
		assertThat(solver.solve(3, Arrays.asList(1)), equalTo(1));
	}
	
	@Test
	public void givenTest03() {
		assertThat(solver.solve(5, Arrays.asList(3)), equalTo(6));
	}
	
	@Test
	public void givenTest04() {
		assertThat(solver.solve(5, Arrays.asList(1, 5)), equalTo(4));
	}

}
