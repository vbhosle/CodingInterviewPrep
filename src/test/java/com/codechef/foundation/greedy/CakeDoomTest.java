package com.codechef.foundation.greedy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CakeDoomTest {

	private static final String NO = "NO";

	@Test
	public void test01() {
		String arrangement = "?";
		int maxColors = 1;
		String expected = "0";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test02() {
		String arrangement = "?0";
		int maxColors = 2;
		String expected = "10";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test03() {
		String arrangement = "79259?087";
		int maxColors = 10;
		String expected = NO;
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test04() {
		String arrangement = "??";
		int maxColors = 2;
		String expected = "01";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test05() {
		String arrangement = "0?1";
		int maxColors = 3;
		String expected = "021";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test06() {
		String arrangement = "?????";
		int maxColors = 5;
		String expected = "01012";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test07() {
		String arrangement = "012";
		int maxColors = 3;
		String expected = "012";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test08() {
		String arrangement = "0120";
		int maxColors = 3;
		String expected = NO;
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test09() {
		String arrangement = "0112";
		int maxColors = 3;
		String expected = NO;
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test10() {
		String arrangement = "0312";
		int maxColors = 3;
		String expected = NO;
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test11() {
		String arrangement = "?10?";
		int maxColors = 3;
		String expected = "0101";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test12() {
		String arrangement = "??1?";
		int maxColors = 2;
		String expected = "1010";
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test13() {
		String arrangement = "??1";
		int maxColors = 2;
		String expected = NO;
		String actual = CakeDoom.minCherryArrangement(arrangement, maxColors);
		assertThat(actual, equalTo(expected));
	}

}
