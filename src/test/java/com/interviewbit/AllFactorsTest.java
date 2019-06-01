package com.interviewbit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AllFactorsTest {

	private AllFactors solver;
	
	@Before
	public void setUp() throws Exception {
		solver= new AllFactors();
	}

	@Test
	public void testFor1() {
		assertThat(solver.allFactors(1), is(Arrays.asList(1)));
	}
	
	@Test
	public void givenTest01() {
		List<Integer> expected = Arrays.asList(1,2,3,4,6,8,9,12,16,18,24,27,32,36,48,54,64,72,81,96,108,128,144,162,192,216,256,288,324,384,432,512,576,648,768,864,1024,1152,1296,1536,1728,2304,2592,3072,3456,4608,5184,6912,9216,10368,13824,20736,27648,41472,82944);
		assertThat(solver.allFactors(82944), is(expected));
	}
	
	@Test
	public void givenTest02() {
		List<Integer> expected = Arrays.asList(1,2,3,4,6,7,8,9,11,12,14,18,21,22,24,28,33,36,42,44,49,56,63,66,72,77,84,88,98,99,126,132,147,154,168,196,198,231,252,264,294,308,392,396,441,462,504,539,588,616,693,792,882,924,1078,1176,1386,1617,1764,1848,2156,2772,3234,3528,4312,4851,5544,6468,9702,12936,19404,38808);
		assertThat(solver.allFactors(38808), is(expected));
	}

}
