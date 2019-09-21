package com.codechef.foundation.greedy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import test.util.TestUtil;

public class TADELIVETest {

	@Test
	public void test01() {
		int andyLimit = 3;
		int bobLimit = 3;
		int[] andyTips = TestUtil.toIntArray("1 2 3 4 5");
		int[] bobTips = TestUtil.toIntArray("5 4 3 2 1");
		long expected = 21L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test02() {
		int andyLimit = 1;
		int bobLimit = 1;
		int[] andyTips = TestUtil.toIntArray("60 80");
		int[] bobTips = TestUtil.toIntArray("55 70");
		long expected = 135L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test03() {
		int andyLimit = 2;
		int bobLimit = 2;
		int[] andyTips = TestUtil.toIntArray("60 80");
		int[] bobTips = TestUtil.toIntArray("1 2");
		long expected = 140L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test04() {
		int andyLimit = 5;
		int bobLimit = 5;
		int[] andyTips = TestUtil.toIntArray("76 8 64 12 77 56");
		int[] bobTips = TestUtil.toIntArray("397 240 293 287 137 433");
		long expected = 1727L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test05() {
		int andyLimit = 1;
		int bobLimit = 1;
		int[] andyTips = TestUtil.toIntArray("5 6");
		int[] bobTips = TestUtil.toIntArray("6 8");
		long expected = 13L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test06() {
		int andyLimit = 6;
		int bobLimit = 8;
		int[] andyTips = TestUtil.toIntArray("15 50 77 52 27 62 63 61");
		int[] bobTips = TestUtil.toIntArray("350 271 916 438 281 998 125 241");
		long expected = 3620L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test07() {
		int andyLimit = 5;
		int bobLimit = 9;
		int[] andyTips = TestUtil.toIntArray("60 98 21 52 9 15 62 74 83");
		int[] bobTips = TestUtil.toIntArray("552 893 44 920 52 830 155 40 557");
		long expected = 4077L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test09() {
		int andyLimit = 2;
		int bobLimit = 2;
		int[] andyTips = TestUtil.toIntArray("5 4 5 2");
		int[] bobTips = TestUtil.toIntArray("5 5 7 1");
		long expected = 19L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void test10() {
		int andyLimit = 2;
		int bobLimit = 2;
		int[] andyTips = TestUtil.toIntArray("5 5 7 1");
		int[] bobTips = TestUtil.toIntArray("5 4 5 2");
		long expected = 19L;
		long actual = TADELIVE.maxTip(andyTips, bobTips, andyLimit, bobLimit);
		assertThat(actual, equalTo(expected));
	}

}
