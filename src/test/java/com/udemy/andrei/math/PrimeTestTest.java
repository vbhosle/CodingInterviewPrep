package com.udemy.andrei.math;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeTestTest {

	private long n;
	private boolean expected;
	
	public PrimeTestTest(long n, boolean expected) {
		this.n = n;
		this.expected = expected;
	}
	
	@Parameters(name = "{0} is prime? {1}")
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
			{1, false },
			{ 2, true },
	        { 10, false },
	        { 19, true },
	        { 22, false },
	        { 23, true },
	        { 23, true },
	        { 7919, true },
	        { 104729, true },
	        { 1281799, true },
	        { 13834103, true },
	        { 160481183, true },
	        { 1824261409, true },
	        { 7919*104729L, false },
	        { 160481183*1824261409L, false },
		});
	}
	
	@Test
	public void isPrimeFaster() {
		assertThat(PrimeTest.isPrimeFaster(n), is(expected));
	}
	
	@Test
	public void isPrime() {
		assertThat(PrimeTest.isPrime(n), is(expected));
	}
}
