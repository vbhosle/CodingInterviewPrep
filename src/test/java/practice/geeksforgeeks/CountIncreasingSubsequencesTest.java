package practice.geeksforgeeks;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountIncreasingSubsequencesTest {

	@Test
	public void test01() {
		int[] arr = {2, 6, 4, 5, 7};
		int k = 3;
		int expected = 5;
		int actual = CountIncreasingSubsequences.numOfIncSubseqOfSizeK01(arr, arr.length, k);
		assertThat(actual, equalTo(expected ));
	}
	
	@Test
	public void test02() {
		int[] arr = {12, 8, 11, 13, 10, 15, 14, 16, 20};
		int k = 4;
		int expected = 39;
		int actual = CountIncreasingSubsequences.numOfIncSubseqOfSizeK01(arr, arr.length, k);
		assertThat(actual, equalTo(expected ));
	}

}
