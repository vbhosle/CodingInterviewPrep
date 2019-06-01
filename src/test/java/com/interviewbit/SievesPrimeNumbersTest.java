package com.interviewbit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SievesPrimeNumbersTest {
	
	private SievesPrimeNumbers solver;

	@Before
	public void setUp() throws Exception {
		solver = new SievesPrimeNumbers();
	}

	@Test
	public void test10() {
		List<Integer> expected = Arrays.asList(2, 3, 5, 7);
		assertThat(solver.sieve(10), is(expected));
	}

}
