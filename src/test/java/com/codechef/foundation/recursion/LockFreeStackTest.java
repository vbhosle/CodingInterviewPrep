package com.codechef.foundation.recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LockFreeStackTest {

	private final static String YES = "Yes";
	private final static String NO = "No";
	
	@Test
	public void test01() {
		int[][] threadNumbers = {
				{1, 2},
				{3, 4}
		};
		int[] sequence = {4, 3, 2, 1};
		
		String actual = LockFreeStack.validSequence(threadNumbers, sequence);
		assertThat(actual, equalTo(YES));
	}
	
	@Test
	public void test02() {
		int[][] threadNumbers = {
				{1, 2},
				{3, 4}
		};
		int[] sequence = {4, 1, 2, 3};
		
		String actual = LockFreeStack.validSequence(threadNumbers, sequence);
		assertThat(actual, equalTo(NO));
	}
	
	@Test
	public void test03() {
		int[][] threadNumbers = {
				{1, 1, 1, 1, 1}, 
				{1, 1, 2},
				{2, 1, 1}
		};
		int[] sequence = {2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
		
		String actual = LockFreeStack.validSequence(threadNumbers, sequence);
		assertThat(actual, equalTo(YES));
	}
	
	@Test
	public void test04() {
		int[][] threadNumbers = {
				{1, 2, 3, 4}
		};
		int[] sequence = {4, 3, 2, 1};
		
		String actual = LockFreeStack.validSequence(threadNumbers, sequence);
		assertThat(actual, equalTo(YES));
	}
	
	@Test
	public void test05() {
		int[][] threadNumbers = {
				{-1, -2},
				{-3, -4}
		};
		int[] sequence = {-4, -2, -3, -1};
		
		String actual = LockFreeStack.validSequence(threadNumbers, sequence);
		assertThat(actual, equalTo(YES));
	}

}
