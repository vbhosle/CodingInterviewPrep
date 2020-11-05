package com.udemy.andrei.array;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static com.udemy.andrei.array.SizeOfLongestSubarrayWithAtmostKDistinctElements.sizeOfLongestSubArray;

@RunWith(Parameterized.class)
public class SizeOfLongestSubarrayWithAtmostKDistinctElementsTest {

	private int[] arr;
	private int k;
	private int expected;
	
	public SizeOfLongestSubarrayWithAtmostKDistinctElementsTest(int[] arr, int k, int expected) {
		this.arr = arr;
		this.k = k;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> parameters(){
		return Arrays.asList(
				new Object[][] {
					{new int[] {1, 5, 2, 1, 7, 2, 1, 5, 5, 7}, 3, 5},
					{new int[] {1, 2, 3, 4, 5}, 6, 5},
					{new int[] {6, 5, 1, 2, 3, 2, 1, 4, 5}, 3, 5},
					{new int[] {1, 2, 1, 0, 1, 1, 0}, 3, 7},
				}
			);
	}
	
	@Test
	public void test() {
		assertThat(sizeOfLongestSubArray(arr, k), equalTo(expected));
	}

}
