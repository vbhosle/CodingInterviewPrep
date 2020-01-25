package com.udemy.andrei.math;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.collection.IsMapContaining;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class PrimeFactorsTest {

	@Test
	public void factorsOf_8() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactors(8);
		assertThat(primeFactors.size(), is(1));
		assertThat(primeFactors, IsMapContaining.hasEntry(2L, 3L));
	}
	
	@Test
	public void factorsOf_17() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactors(17);
		assertThat(primeFactors.size(), is(1));
		assertThat(primeFactors, IsMapContaining.hasEntry(17L, 1L));
	}
	

	@Test
	public void factorsOf_200() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactors(200);
		assertThat(primeFactors.size(), is(2));
		assertThat(primeFactors, IsMapContaining.hasEntry(2L, 3L));
		assertThat(primeFactors, IsMapContaining.hasEntry(5L, 2L));
	}
	
	@Test
	public void factorsOf_997210243() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactors(997210243);
		assertThat(primeFactors.size(), is(2));
		assertThat(primeFactors, IsMapContaining.hasEntry(99991L, 1L));
		assertThat(primeFactors, IsMapContaining.hasEntry(9973L, 1L));
		System.out.println(Integer.MAX_VALUE);
	}
	
	@Ignore
	@Test
	public void factorsOf_292759629017566847() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactors(292759629017566847L);
		assertThat(primeFactors.size(), is(2));
		assertThat(primeFactors, IsMapContaining.hasEntry(160481183L, 1L));
		assertThat(primeFactors, IsMapContaining.hasEntry(1824261409L, 1L));
	}
	
	@Ignore
	@Test
	public void factorsOf_292759629017566847_Fast() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactorsFast(292759629017566847L);
		assertThat(primeFactors.size(), is(2));
		assertThat(primeFactors, IsMapContaining.hasEntry(160481183L, 1L));
		assertThat(primeFactors, IsMapContaining.hasEntry(1824261409L, 1L));
	}
	
	@Test
	public void factorsOf_13834103_Fast() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactorsFast(13834103L);
		assertThat(primeFactors.size(), is(1));
		assertThat(primeFactors, IsMapContaining.hasEntry(13834103L, 1L));
	}
	
	@Test
	public void factorsOf_13834103_WithSieves() {
		Map<Long, Long> primeFactors = PrimeFactors.primeFactorsWithSieves(13834103L);
		assertThat(primeFactors.size(), is(1));
		assertThat(primeFactors, IsMapContaining.hasEntry(13834103L, 1L));
	}

}
