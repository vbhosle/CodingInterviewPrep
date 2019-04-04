package com.leetcode.easy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.SearchInsertPosition;

public class SearchInsertPositionTest {

	private SearchInsertPosition solver;
	
	@Before
	public void setUp() {
		solver = new SearchInsertPosition();
	}

	@Test
	public void insertIntoEmptyArrayReturnsZero() {
		assertThat(solver.searchInsert(new int[0], 5), equalTo(0));
	}
	
	@Test
	public void insertingLargestElementReturnsPositionAfterArrayEnd() {
		int[] arr = {2,4,5,6,8,9};
		assertThat(solver.searchInsert(arr, 15), equalTo(6));
	}

	@Test
	public void insertingSmallestElementReturnsZero() {
		int[] arr = {2,4,5,6,8,9};
		assertThat(solver.searchInsert(arr, -1), equalTo(0));
	}
	
	@Test
	public void testNumberInsertedInTheMiddlePosition() {
		int[] arr = {2,4,5,6,8,9};
		assertThat(solver.searchInsert(arr, 7), equalTo(4));
	}
	
	@Test
	public void testInsertingRepeatingNumber() {
		int[] arr = {1,3,5,6};
		assertThat(solver.searchInsert(arr, 5), equalTo(2));
	}
}
