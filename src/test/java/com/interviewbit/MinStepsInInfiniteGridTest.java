package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MinStepsInInfiniteGridTest {

	private MinStepsInInfiniteGrid solver;

	@Before
	public void setUp() throws Exception {
		solver = new MinStepsInInfiniteGrid();
	}

	@Test
	public void minStepsBetweenPointsHorizontalRight() {
		assertThat(solver.minStepsBetweenPoints(-3, -2, 2, -2), equalTo(5));
	}

	@Test
	public void minStepsBetweenPointsHorizontalLeft() {
		assertThat(solver.minStepsBetweenPoints(2, -2, -3, -2), equalTo(5));
	}

	@Test
	public void minStepsBetweenPointsVerticalUp() {
		assertThat(solver.minStepsBetweenPoints(-3, -2, -3, 2), equalTo(4));
	}

	@Test
	public void minStepsBetweenPointsVerticalDown() {
		assertThat(solver.minStepsBetweenPoints(-3, 2, -3, -2), equalTo(4));
	}
	
	@Test
	public void minStepsBetweenPointDiagonalNorthEast() {
		assertThat(solver.minStepsBetweenPoints(-3, -2, 1, 2), equalTo(4));
	}
	
	@Test
	public void minStepsBetweenPointDiagonalNorthWest() {
		assertThat(solver.minStepsBetweenPoints(2, -2, -2, 2), equalTo(4));
	}
	
	@Test
	public void minStepsBetweenPointDiagonalSouthWest() {
		assertThat(solver.minStepsBetweenPoints(1, 2, -3, -2), equalTo(4));
	}
	
	@Test
	public void minStepsBetweenPointDiagonalSouthEast() {
		assertThat(solver.minStepsBetweenPoints(-2, 2, 2, -2), equalTo(4));
	}
	
	@Test
	public void minStepsBetweenPointCrissCross() {
		assertThat(solver.minStepsBetweenPoints(-1, -2, 0, 1), equalTo(3));
	}
	
	@Test
	public void minStepsBetweenSamePoints() {
		assertThat(solver.minStepsBetweenPoints(-1, -2, -1, -2), equalTo(0));
	}
	
	@Test
	public void givenInput() {
		List<Integer> X = Arrays.asList(0, 1, 1);
		List<Integer> Y = Arrays.asList(0, 1, 2);
		assertThat(solver.coverPoints(X, Y), equalTo(2));
	}
	

	@Test
	public void coverPointsTest2() {
		List<Integer> X = Arrays.asList(0, 1, 2);
		List<Integer> Y = Arrays.asList(0, 3, 0);
		assertThat(solver.coverPoints(X, Y), equalTo(6));
	}

}
