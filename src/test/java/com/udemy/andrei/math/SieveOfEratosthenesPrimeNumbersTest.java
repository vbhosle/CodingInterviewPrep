package com.udemy.andrei.math;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

public class SieveOfEratosthenesPrimeNumbersTest {

	private static final Matcher<Integer> primeMatcher = new PrimeMatcher();
	public static final class PrimeMatcher extends BaseMatcher<Integer> {
		@Override
		public boolean matches(Object item) {
			return PrimeTest.isPrimeFaster((int) item);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("prime");
		}

		@Override
		public void describeMismatch(Object item, Description description) {
			description.appendValue(item).appendText(" is not a prime");
		}
	}

	@Test
	public void primesTill_20() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(20);
		
		assertThat(primes.size(), is(8));
		assertThat(primes, everyItem(isPrime()));
	}
	
	@Test
	public void primesTill_100() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(100);
		
		assertThat(primes.size(), is(25));
		assertThat(primes, everyItem(isPrime()));
	}
	
	@Test
	public void primesTill_10000() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(10000);
		
		assertThat(primes.size(), is(1229));
		assertThat(primes, everyItem(isPrime()));
	}
	
	@Test
	public void primesTill_100000() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(100000);
		
		assertThat(primes.size(), is(9592));
		assertThat(primes, everyItem(isPrime()));
	}
	
	@Test
	public void primesTill_1000000() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(1000000);
		
		assertThat(primes.size(), is(78498));
		assertThat(primes, everyItem(isPrime()));
	}
	

	@Test
	public void primesTill_899999963() {
		List<Integer> primes = SieveOfEratosthenesPrimeNumbers.primeNumbersTill(89999999);
		
		assertThat(primes.size(), is(5216954));
		assertThat(primes, everyItem(isPrime()));
	}
	
	public static PrimeMatcher isPrime(){
		return new PrimeMatcher();
	}

}
