package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModularExponentiationTest {

	private ModularExponentiation solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new ModularExponentiation();
	}

	@Test
	public void testNegativeNumber() {
		int x = -1;
		int y = 1;
		int mod = 20;
		int expected = 19;
		int actual = solver.Mod(x, y, mod);
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testBigNumbers01() {
		int x = 748493;
		int y = 2;
		int mod = 97;
		int expected = 32;
		int actual = solver.Mod(x, y, mod);
		assertThat(actual, equalTo(expected));
	}
	

	@Test
	public void testBigNumbers02() {
		int x = 71045970;
		int y = 41535484;
		int mod = 64735492;
		int expected = 20805472;
		int actual = solver.Mod(x, y, mod);
		assertThat(actual, equalTo(expected));
	}

}
