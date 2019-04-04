package com.spoj;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HistograTest {

	private Histogra solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new Histogra();
	}


	@Test
	public void nullArrayReturnZero() {
		assertThat(solver.largestRectangleInHistogram(null), equalTo(0L));
	}

	@Test
	public void emptyArrayReturnZero() {
		assertThat(solver.largestRectangleInHistogram(new int[]{}), equalTo(0L));
	}
	
	@Test
	public void zeroHeightsReturnZero() {
		assertThat(solver.largestRectangleInHistogram(new int[]{0,0,0}), equalTo(0L));
	}
	
	@Test
	public void sameHeightsReturnHeightIntoNoOfBuildings() {
		int height = 1000000000;
		int noOfBuildings = 3;
		int[] histogram = new int[noOfBuildings];
		Arrays.fill(histogram, height);
		assertThat(solver.largestRectangleInHistogram(histogram), equalTo(1L*height*noOfBuildings));
	}
	
	@Test
	public void singleBuildingWithLargestRectangleTest() {
		assertThat(solver.largestRectangleInHistogram(new int[]{2,2,50,2,2}), equalTo(50L));
	}
	
	@Test
	public void spojTest1() {
		assertThat(solver.largestRectangleInHistogram(new int[]{2, 1, 4, 5, 1, 3, 3}), equalTo(8L));
	}
	
	@Test
	public void increasingOrder() {
		assertThat(solver.largestRectangleInHistogram(new int[]{1, 2, 3, 4, 5}), equalTo(9L));
	}
	
	@Test
	public void decreasingOrder() {
		assertThat(solver.largestRectangleInHistogram(new int[]{5, 4, 3, 2, 1}), equalTo(9L));
	}
	
	@Test
	public void biggestPossibleRectangleTest() {
		int maxHeight = 1000000000;
		int maxBuildings = 100000;
		int[] histogram = new int[maxBuildings];
		Arrays.fill(histogram, maxHeight);
		assertThat(solver.largestRectangleInHistogram(histogram), equalTo(1L*maxHeight*maxBuildings));
	}

}
