package com.codechef.foundation.greedy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CleTabTest {

	@Test
	public void test01() {
		int tables = 2;
		int[] orders = { 1, 2, 3, 4 };
		int expected = 4;
		int actual = CleTab.minCleanups(tables, orders);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test02() {
		int tables = 3;
		int[] orders = { 4, 1 };
		int expected = 2;
		int actual = CleTab.minCleanups(tables, orders);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test03() {
		int tables = 3;
		int[] orders = { 1, 2, 1, 3, 4, 1 };
		int expected = 4;
		int actual = CleTab.minCleanups(tables, orders);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void test04() {
		int tables = 3;
		int[] orders = { 1, 2, 1, 3, 4 };
		int expected = 4;
		int actual = CleTab.minCleanups(tables, orders);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test05() {
		int tables = 2;
		int[] orders = {1, 2, 3, 1, 3, 1, 3, 1, 3, 2, 2, 2, 2, 2 };
		int expected = 4;
		int actual = CleTab.minCleanups(tables, orders);
		assertThat(actual, equalTo(expected));
	}

}
