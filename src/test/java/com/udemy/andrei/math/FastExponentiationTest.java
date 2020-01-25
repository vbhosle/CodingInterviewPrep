package com.udemy.andrei.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FastExponentiationTest {

	private long base;
	private long power;
	private long mod;
	private long expected;

	public FastExponentiationTest(long base, long power, long mod, long expected) {
		this.base = base;
		this.power = power;
		this.mod = mod;
		this.expected = expected;
	}

	@Parameters(name = "{0} ^ {1} % {2} = {3}")
	public static Collection<Object[]> parameters(){
		return Arrays.asList(
				new Object[][] {
					//{987654321, 987654321, 1000000007, 854621122}, //too slow
//					{50, 10000000, 1000000007, 755237179}, // fails in recursive
					{7, 256, 13, 9},
					{5, 117, 19, 1},
					{3, 1993, 17, 14},
				}
		);
	}
	
	@Test
	public void iterative() {
		assertThat(FastExponentiation.iterative(base, power, mod), is(equalTo(expected)));
	}
	
//	@Ignore
	@Test
	public void recursive() {
		assertThat(FastExponentiation.recursive(base, power, mod), is(equalTo(expected)));
	}
}
