package com.codechef.foundation.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class CopsTest {

	@Ignore
	@Test
	public void testBinarySearch01() {
		int[] copsHouses = new int[] { 12, 52, 56, 8 };
		int house = 3;
		int housesCovered = 56;
		boolean safe = Cops.binarySearch(copsHouses, house, housesCovered);
		assertFalse(safe);
	}

	@Ignore
	@Test
	public void testBinarySearchMultiplesOfTenAreSafe() {
		int[] copsHouses = new int[] { 5, 15, 25, 35, 45, 55, 65, 75, 85, 95 };
		int housesCovered = 4;
		assertTrue(Cops.binarySearch(copsHouses, 10, housesCovered));
		assertTrue(Cops.binarySearch(copsHouses, 20, housesCovered));
		assertTrue(Cops.binarySearch(copsHouses, 30, housesCovered));
		assertTrue(Cops.binarySearch(copsHouses, 100, housesCovered));

		assertFalse(Cops.binarySearch(copsHouses, 11, housesCovered));
		assertFalse(Cops.binarySearch(copsHouses, 19, housesCovered));
		assertFalse(Cops.binarySearch(copsHouses, 15, housesCovered));
		assertFalse(Cops.binarySearch(copsHouses, 98, housesCovered));
	}

	@Test
	public void testbinarySearchNearestGreat01() {
		int[] copsHouses = new int[] { 5, 15, 25, 35, 45, 55, 65, 75, 85, 95 };
		int housesCovered = 4;
		assertThat(Cops.binarySearchNearestGreat(copsHouses, 10, housesCovered), equalTo(15));
		assertThat(Cops.binarySearchNearestGreat(copsHouses, 46, housesCovered), equalTo(55));
		assertThat(Cops.binarySearchNearestGreat(copsHouses, 75, housesCovered), equalTo(75));
	}
	
	@Test
	public void testbinarySearchNearestSmall01() {
		int[] copsHouses = new int[] { 5, 15, 25, 35, 45, 55, 65, 75, 85, 95 };
		int housesCovered = 4;
		assertThat(Cops.binarySearchNearestSmall(copsHouses, 10, housesCovered), equalTo(5));
		assertThat(Cops.binarySearchNearestSmall(copsHouses, 46, housesCovered), equalTo(45));
		assertThat(Cops.binarySearchNearestSmall(copsHouses, 75, housesCovered), equalTo(75));
	}
}
