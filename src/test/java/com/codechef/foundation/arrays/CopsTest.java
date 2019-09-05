package com.codechef.foundation.arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CopsTest {

	@Test
	public void test01() {
		int[] copsHouses = new int[] { 12, 52, 56, 8 };
		int housesCovered = 7*8;
		int safeHouses = Cops.totalSafeHouses(100, copsHouses, housesCovered);
		assertThat(safeHouses, equalTo(0));
	}
	
	@Test
	public void test02() {
		int[] copsHouses = new int[] { 21, 75 };
		int housesCovered = 10 * 2;
		int safeHouses = Cops.totalSafeHouses(100, copsHouses, housesCovered);
		assertThat(safeHouses, equalTo(18));
	}
	
	@Test
	public void test03() {
		int[] copsHouses = new int[] { 10, 51 };
		int housesCovered = 5*8;
		int safeHouses = Cops.totalSafeHouses(100, copsHouses, housesCovered);
		assertThat(safeHouses, equalTo(9));
	}

}
